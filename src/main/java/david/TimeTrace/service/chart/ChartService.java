package david.TimeTrace.service.chart;

import david.TimeTrace.domain.ActivityTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public interface ChartService
{
    public List<Duration[]> get3monthDurations(LocalDateTime targetDate);

    public HashMap<LocalDateTime, List<ActivityTime>> getActivityTimes(LocalDateTime targetDate);

}
