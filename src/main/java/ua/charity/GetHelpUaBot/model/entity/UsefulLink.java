package ua.charity.GetHelpUaBot.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import ua.charity.GetHelpUaBot.model.entity.location_details.Country;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Useful_links")
public class UsefulLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="country_id", nullable = false)
    private Country country;
    @Type(type = "text")
    private String text;
}
