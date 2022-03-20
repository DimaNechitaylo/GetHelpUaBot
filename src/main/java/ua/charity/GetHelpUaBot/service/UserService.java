package ua.charity.GetHelpUaBot.service;


import ua.charity.GetHelpUaBot.model.dto.UserDto;
import ua.charity.GetHelpUaBot.model.entity.User;

public interface UserService {
    void save (Long id, String username, String firstName,String lastName, String phoneNumber);

    void saveBaseInfo(Long id, String username);

    void update (UserDto userDto);

    UserDto findUserById(Long id);

    public boolean userExists(Long id);

    User mapToUser(UserDto userDto);

    UserDto mapToDto(User user);
}
