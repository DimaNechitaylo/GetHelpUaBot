package ua.charity.GetHelpUaBot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

 

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    private Long id;
    @NonNull
    private Instant creationDatetime;
    @NonNull
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recepient_id", referencedColumnName = "id")
    private User recepient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id", referencedColumnName = "id")
    private User donor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logistician_id", referencedColumnName = "id")
    private User logistician;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Task(String description){
        this.description = description;
    }
}