package david.TimeTrace.domain;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Builder
@Data
public class TimeAndDuration
{
    private LocalDateTime startTime;
    private Duration duration;
}
