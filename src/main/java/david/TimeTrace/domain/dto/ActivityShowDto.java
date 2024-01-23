package david.TimeTrace.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ActivityShowDto
{
    private Long id;
    private String title;
    private String content;
    private List<String> stackImages;

    @Builder
    public ActivityShowDto(Long id, String title, String content, List<String> stackImages)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.stackImages = stackImages;
    }
}
