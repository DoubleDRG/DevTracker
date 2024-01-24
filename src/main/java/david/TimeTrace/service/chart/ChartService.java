package david.TimeTrace.service.chart;

import david.TimeTrace.domain.ActivityTime;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public interface ChartService
{
    public List<Long[]> get3monthDurations(LocalDateTime targetDate);

}
