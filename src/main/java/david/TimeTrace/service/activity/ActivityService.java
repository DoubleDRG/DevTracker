package david.TimeTrace.service.activity;

import com.fasterxml.jackson.core.JsonProcessingException;
import david.TimeTrace.domain.Activity;
import david.TimeTrace.domain.dto.ActivitySaveDto;

public interface ActivityService
{
    public Activity save(ActivitySaveDto saveDto) throws JsonProcessingException;

    public Activity update(Long id, Activity updateParam);

    public void delete(Long id);
}
