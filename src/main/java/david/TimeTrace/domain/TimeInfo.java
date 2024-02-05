package david.TimeTrace.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

import static lombok.AccessLevel.*;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Embeddable
public class TimeInfo
{
    private LocalDateTime createDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;

    @Builder
    public TimeInfo(LocalDateTime createDate, LocalDateTime startTime, LocalDateTime endTime, Duration duration)
    {
        this.createDate = createDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }
}
