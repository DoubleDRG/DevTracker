package david.TimeTrace.service.chart;

import david.TimeTrace.domain.Activity;
import david.TimeTrace.repository.activity.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Transactional
@Service
public class ChartServiceImplV1 implements ChartService
{
    private final ActivityRepository activityRepository;


    // === 반드시 테스트 코드 작성할 것!! ==//
    // 3 * 31 2차원 배열 반환
    // [0,0,0,7,5,1,...,8] => 이번달
    // [8,1,2,3,5,1,...,8] => 1달전
    // [1,2,1,7,5,1,...,8] => 2달전
    @Override
    public List<Long[]> get3monthDurations(LocalDateTime targetDate)
    {
        List<Long[]> durations = new ArrayList<Long[]>();

        //이번달, 한달전, 두달전
        durations.add(getDurationList(targetDate));
        durations.add(getDurationList(targetDate.minusMonths(1)));
        durations.add(getDurationList(targetDate.minusMonths(2)));

        return durations;
    }

    // 특정 달의 날짜별 duration 리스트를 반환
    // [0,0,0,7,5,1,..., 7] => 크기는 31고정
    private Long[] getDurationList(LocalDateTime targetDate)
    {
        List<Activity> list = activityRepository.findByMonth(targetDate.getYear(), targetDate.getMonthValue());

        Long[] durations = new Long[31];
        Arrays.fill(durations, 0L);

        for (Activity activity : list)
        {
            int day = activity.getStartTime().getDayOfMonth();
            durations[day - 1] = durations[day-1]+activity.getDuration()/3600;
        }
        return durations;
    }
}

