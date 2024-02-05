package david.TimeTrace.domain;

import jakarta.persistence.*;
import lombok.*;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class Stack
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stack_id")
    private Long id;

    private String name;

    @Column(length = 1000)
    private String imageUrl;
    private Boolean selected;

    @Builder
    public Stack(String name, String imageUrl, Boolean selected)
    {
        this.name = name;
        this.imageUrl = imageUrl;
        this.selected = selected;
    }

    public void select()
    {
        this.selected = true;
    }

    public void unselect()
    {
        this.selected = false;
    }
}
