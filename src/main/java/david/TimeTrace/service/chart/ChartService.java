package david.TimeTrace.service.chart;

import java.time.LocalDateTime;
import java.util.List;

public interface ChartService
{
    public List<Long[]> get3monthDurations(LocalDateTime targetDate);

}
