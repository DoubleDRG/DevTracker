package david.TimeTrace.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import david.TimeTrace.domain.Stack;
import david.TimeTrace.domain.dto.ActivitySaveDto;
import david.TimeTrace.service.activity.ActivityService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Component
public class ActivityInit
{
    private final ActivityService activityService;

    @PostConstruct
    void init() throws JsonProcessingException
    {
        LocalDateTime start = LocalDateTime.of(2023, 11, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, 1, 31, 23, 59, 59);

        for(int i = 0; i< 200; i++)
        {
            LocalDateTime randomDateTime = getRandomDateTime(start, end);
            int randomHours = ThreadLocalRandom.current().nextInt(1, 6);
            String title = "제목" + i;
            List<String> stacks = new ArrayList<>();
            LocalDateTime startTime = getRandomDateTime(start, end);
            LocalDateTime endTime = startTime.plusHours(randomHours);
            String content = "내용" + i;

            ActivitySaveDto saveDto = new ActivitySaveDto(title, stacks, startTime, endTime, content);
            System.out.println("saveDto = " + saveDto);
            activityService.save(saveDto);
        }
    }

    //랜덤한 activity를 생성하기 위한, 랜덤 시간 생성 (2023 11월 1일 ~ 2024년 1월 31일)
    private static LocalDateTime getRandomDateTime(LocalDateTime start, LocalDateTime end) {
        long startSeconds = start.toEpochSecond(ZoneOffset.UTC);
        long endSeconds = end.toEpochSecond(ZoneOffset.UTC);
        long randomSeconds = ThreadLocalRandom.current().nextLong(startSeconds, endSeconds);

        return LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC);
    }
}
