package david.TimeTrace.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.time.Duration;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Activity
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "activity_id")
    private Long id;
    private String title;

    //{spring:springUrl, java:javaUrl}의 Json 데이터 저장
    @Column(length=20000)
    private String stacks;

    @Embedded
    private TimeInfo timeInfo;

    @Column(length = 20000)
    private String content;

    @Builder
    public Activity(String title, String stacks, LocalDateTime startTime, LocalDateTime endTime, Long duration, String content)
    {
        this.title = title;
        this.stacks = stacks;

        TimeInfo timeInfo = TimeInfo.builder()
                .startTime(startTime)
                .endTime(endTime)
                .duration(Duration.ofSeconds(duration))
                .build();

        this.timeInfo = timeInfo;
        this.content = content;
    }
}
