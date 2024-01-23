package david.TimeTrace.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ActivitySummary
{
    private Long id;
    private String title;
    private String content;
    private List<String> stackImages;

    @Builder
    public ActivitySummary(Long id, String title, String content, List<String> stackImages)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.stackImages = stackImages;
    }
}
