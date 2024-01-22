package david.TimeTrace.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stack
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageUrl;
    private Boolean selected;

    protected Stack()
    {
    }

    @Builder
    public Stack(String name, String imageUrl, Boolean selected)
    {
        this.name = name;
        this.imageUrl = imageUrl;
        this.selected = selected;
    }
}
