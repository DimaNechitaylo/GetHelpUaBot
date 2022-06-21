package ua.charity.GetHelpUaBot.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Possibility {
    @Id
    private Long id;
    @NonNull
    @Type(type="text")
    private String description;
    private Instant creationDateime;

    public Possibility(String description){
        this.description = description;
    }
}

