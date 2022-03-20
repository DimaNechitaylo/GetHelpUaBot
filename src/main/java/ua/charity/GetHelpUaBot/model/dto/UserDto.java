package ua.charity.GetHelpUaBot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.charity.GetHelpUaBot.utils.LocaleTextManager;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocationDto locationDto;
    private String nativeRegion;
    private List<String> possibilities;
    private List<String> tasks;

    @Override
    public String toString(){
        StringBuilder userDto = new StringBuilder();
        userDto.append(LocaleTextManager.getMessageText("profile.header")+"\n\n");
        userDto.append(LocaleTextManager.getMessageText("profile.first_name")+ (this.getFirstName()==null ? " --" : this.getFirstName()) + "\n");
        userDto.append(LocaleTextManager.getMessageText("profile.last_name") + (this.getLastName()==null ? " --" : this.getLastName()) + "\n");
        userDto.append(LocaleTextManager.getMessageText("profile.phone_number")+ (this.getPhoneNumber()==null ? " --" : this.getPhoneNumber()) + "\n");
        userDto.append(LocaleTextManager.getMessageText("profile.location")+ (this.getLocationDto() == null ? " --" : this.getLocationDto().toString()) + "\n");
        userDto.append(LocaleTextManager.getMessageText("profile.native_city")+ (this.getNativeRegion()==null ? " --" : this.getNativeRegion()) + "\n\n");
        userDto.append(LocaleTextManager.getMessageText("profile.possibilities")+"\n");
        if(this.getPossibilities()==null) userDto.append(" --\n");
        else this.getPossibilities().forEach(p -> userDto.append(p + "\n"));
        userDto.append(LocaleTextManager.getMessageText("profile.needs")+"\n");
        if(this.getTasks()==null) userDto.append(" --\n");
        else this.getTasks().forEach(n -> userDto.append(n + "\n"));
        return userDto.toString();
    }
}
