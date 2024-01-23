package david.TimeTrace.service.activity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.Stack;
import david.TimeTrace.domain.dto.ActivitySaveDto;
import david.TimeTrace.repository.activity.ActivityRepository;
import david.TimeTrace.repository.stack.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        for (String stackName : list)
        {
            Optional<Stack> stack = stackRepository.findByName(stackName);
            stack.ifPresent(s -> map.put(s.getName(), s.getImageUrl()));
        }
        return objectMapper.writeValueAsString(map);
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
