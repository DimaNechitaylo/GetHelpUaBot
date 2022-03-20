package ua.charity.GetHelpUaBot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private String countryName;
    private String regionName;
    private String cityName;
    private Double longitude;
    private Double latitude;

    @Override
    public String toString(){
        return (countryName == null ? "--" : countryName) + ", " +
                (regionName == null ? "--" : regionName) + ", " +
                (cityName == null ? "--" : cityName) ;

    }
}
