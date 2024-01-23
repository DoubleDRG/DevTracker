package david.TimeTrace.service.activity;

import com.fasterxml.jackson.core.JsonProcessingException;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.dto.ActivityDetailShowDto;
import david.TimeTrace.domain.dto.ActivitySaveDto;
import david.TimeTrace.domain.dto.ActivityShowDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ActivityService
{
    public Activity save(ActivitySaveDto saveDto) throws JsonProcessingException;

    public Map<LocalDate,List<ActivityShowDto>> findActivitiesByMonth(int year, int month) throws JsonProcessingException;

    public ActivityDetailShowDto findById(Long id) throws JsonProcessingException;
    public Activity update(Long id, Activity updateParam);

    public void delete(Long id);
}
