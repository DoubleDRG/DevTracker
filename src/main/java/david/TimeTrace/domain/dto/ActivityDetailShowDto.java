package david.TimeTrace.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActivityDetailShowDto
{
    private Long id;
    private String title;
    private List<String> stackImages;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String Content;

    @Builder
    public ActivityDetailShowDto(Long id, String title, List<String> stackImages, LocalDateTime startTime, LocalDateTime endTime, String content)
    {
        this.id = id;
        this.title = title;
        this.stackImages = stackImages;
        this.startTime = startTime;
        this.endTime = endTime;
        Content = content;
    }
}
