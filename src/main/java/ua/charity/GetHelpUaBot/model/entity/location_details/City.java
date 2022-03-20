package ua.charity.GetHelpUaBot.model.entity.location_details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {
    @Id
    private Long id;
    private String name;

    public City(String name) {
        this.name = name;
    }
}