package david.TimeTrace.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActivitySaveDto
{
    private String title;
    private List<String> stacks;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String Content;

    public ActivitySaveDto(String title, List<String> stacks, LocalDateTime startTime, LocalDateTime endTime, String content)
    {
        this.title = title;
        this.stacks = stacks;
        this.startTime = startTime;
        this.endTime = endTime;
        Content = content;
    }
}
