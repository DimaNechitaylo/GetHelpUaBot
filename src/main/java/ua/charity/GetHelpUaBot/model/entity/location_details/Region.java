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
public class Region {
    @Id
    private Long id;
    private String name;
    private boolean main;

    public Region(String name) {
        this.name = name;
    }
}