package david.TimeTrace.domain;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class ActivityTime
{
    private LocalDateTime createDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;

    @Builder
    public ActivityTime(LocalDateTime createDate, LocalDateTime startTime, LocalDateTime endTime, Duration duration)
    {
        this.createDate = createDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }
}
