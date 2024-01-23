package david.TimeTrace.service.activity;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.Stack;
import david.TimeTrace.domain.dto.ActivitySaveDto;
import david.TimeTrace.domain.dto.ActivityShowDto;
import david.TimeTrace.repository.activity.ActivityRepository;
import david.TimeTrace.repository.stack.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Transactional
@RequiredArgsConstructor
@Service
public class ActivityServiceImplV1 implements ActivityService
{
    private final ActivityRepository activityRepository;
    private final StackRepository stackRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Activity save(ActivitySaveDto saveDto) throws JsonProcessingException
    {
        String stackJson = extractStackJson(saveDto);
        Long durationSeconds = Duration.between(saveDto.getStartTime(), saveDto.getEndTime()).getSeconds();

        Activity activity = Activity.builder()
                .title(saveDto.getTitle())
                .stacks(stackJson)
                .startTime(saveDto.getStartTime())
                .endTime(saveDto.getEndTime())
                .duration(durationSeconds)
                .content(saveDto.getContent())
                .build();

        return activityRepository.save(activity);
    }

    //saveDto의 stacks이름 리스트를 Json으로 반환함
    // ["Java", "Python",... ] -> "{"Java":"java이미지Url", "Python":"Python이미지Url", ...}"
    private String extractStackJson(ActivitySaveDto saveDto) throws JsonProcessingException
    {
        List<String> list = saveDto.getStacks();
        Map<String, String> map = new HashMap<>();

        if (list == null) return "{}";

        for (String stackName : list)
        {

            Optional<Stack> stack = stackRepository.findByName(stackName);
            stack.ifPresent(s -> map.put(s.getName(), s.getImageUrl()));
        }
        return objectMapper.writeValueAsString(map);
    }

    @Override
    public Map<LocalDate, List<ActivityShowDto>> findActivitiesByMonth(int year, int month) throws JsonProcessingException
    {
        List<Activity> activities = activityRepository.findByMonth(year, month);
        LinkedHashMap<LocalDate, List<ActivityShowDto>> map = new LinkedHashMap<>();

        // 최신순
        // {날짜1: [activity1, activity2, ...]}
        // {날짜2: [activity1, activity2, activity3, ...]}
        for (Activity activity : activities)
        {
            LocalDate date = activity.getStartTime().toLocalDate();

            HashMap<String, String> stackMap = objectMapper.readValue(activity.getStacks(),HashMap.class);
            List<String> stackUrls = new ArrayList<>(stackMap.values());

            ActivityShowDto activityShowDto = new ActivityShowDto(
                    activity.getId(),
                    activity.getTitle(),
                    activity.getContent(),
                    stackUrls);

            if (map.containsKey(date))
            {

                map.get(date).add(activityShowDto);
            } else
            {
                ArrayList<ActivityShowDto> list = new ArrayList<>();
                list.add(activityShowDto);
                map.put(date, list);
            }
        }
        return map;
    }

    @Override
    public Activity update(Long id, Activity updateParam)
    {
        Activity activity = activityRepository.findById(id);
        activity.setTitle(updateParam.getTitle());
        activity.setStacks(updateParam.getStacks());
        activity.setStartTime(updateParam.getStartTime());
        activity.setEndTime(updateParam.getEndTime());
        activity.setDuration(updateParam.getDuration());
        activity.setContent(updateParam.getContent());
        return activity;
    }

    @Override
    public void delete(Long id)
    {
        activityRepository.remove(id);
    }
}
