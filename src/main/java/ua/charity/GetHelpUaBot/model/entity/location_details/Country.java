package ua.charity.GetHelpUaBot.model.entity.location_details;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
    @Id
    private Long id;
    @NonNull
    private String name;
    private boolean main;

    public Country(String name) { this.name = name; }
}
