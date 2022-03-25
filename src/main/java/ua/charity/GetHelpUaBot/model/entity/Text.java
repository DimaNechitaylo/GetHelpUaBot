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
@Table(name = "Texts")
public class Text {
    @Id
    private String mne;
    @Type(type = "text")
    private String text;
}

