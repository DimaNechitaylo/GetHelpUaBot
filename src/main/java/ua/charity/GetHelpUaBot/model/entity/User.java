package ua.charity.GetHelpUaBot.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id", nullable = false)
    private Location location;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Possibility> possibilities;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Task> tasks;
    private Instant creationDateime;
    private Instant changeDateime;
}
