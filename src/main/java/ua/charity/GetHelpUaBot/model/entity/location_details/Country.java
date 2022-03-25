package ua.charity.GetHelpUaBot.model.entity.location_details;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(length = 64)
    private String name;
    private boolean main;

    public Country(String name) { this.name = name; }
}
