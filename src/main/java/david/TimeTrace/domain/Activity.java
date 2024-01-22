package david.TimeTrace.domain;

import jakarta.persistence.*;
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

    //{spring:springUrl, java:javaUrl}의 Json 데이터 저장
    @Lob
    private String stacks;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;

    @Lob
    private String content;


}
