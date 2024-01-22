package david.TimeTrace.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Activity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    protected Activity()
    {
    }

    @Builder
    public Activity(String title, String stacks, LocalDateTime startTime, LocalDateTime endTime, Duration duration, String content)
    {
        this.title = title;
        this.stacks = stacks;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.content = content;
    }

    //{spring:springUrl, java:javaUrl}의 Json 데이터 저장
    @Lob
    private String stacks;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;

    @Lob
    private String content;


}
