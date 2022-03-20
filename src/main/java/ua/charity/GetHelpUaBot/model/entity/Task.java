package ua.charity.GetHelpUaBot.model.entity;

import lombok.*;

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
@Table(name = "Tasks")
public class Task {
    @Id
    private Long id;
    @NonNull
    private String text;
    private Instant creationDateime;


    public Task(String text){
        this.text = text;
    }
}