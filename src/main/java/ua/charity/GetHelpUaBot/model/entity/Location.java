package ua.charity.GetHelpUaBot.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.charity.GetHelpUaBot.model.entity.location_details.City;
import ua.charity.GetHelpUaBot.model.entity.location_details.Country;
import ua.charity.GetHelpUaBot.model.entity.location_details.Region;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="country_id", nullable = false)
    private Country country;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="region_id", nullable = false)
    private Region region;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="city_id", nullable = false)
    private City city;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="native_region_id", nullable = false)
    private Region nativeRegion;
    private Double longitude;
    private Double latitude;

}

