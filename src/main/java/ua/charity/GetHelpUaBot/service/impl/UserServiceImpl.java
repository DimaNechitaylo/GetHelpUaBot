package ua.charity.GetHelpUaBot.service.impl;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.charity.GetHelpUaBot.exceptions.UserNotFoundException;
import ua.charity.GetHelpUaBot.model.dto.LocationDto;
import ua.charity.GetHelpUaBot.model.dto.UserDto;
import ua.charity.GetHelpUaBot.model.entity.Location;
import ua.charity.GetHelpUaBot.model.entity.Possibility;
import ua.charity.GetHelpUaBot.model.entity.Task;
import ua.charity.GetHelpUaBot.model.entity.User;
import ua.charity.GetHelpUaBot.model.entity.location_details.City;
import ua.charity.GetHelpUaBot.model.entity.location_details.Country;
import ua.charity.GetHelpUaBot.model.entity.location_details.Region;
import ua.charity.GetHelpUaBot.repository.UserRepository;
import ua.charity.GetHelpUaBot.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepositoryImpl;


    @Override
    public void save(Long id,String username, String firstName,String lastName, String phoneNumber) {
        userRepositoryImpl.save(User.builder()
                .id(id)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(Long.parseLong(phoneNumber))
                .build());
    }

    @Override
    public void saveBaseInfo(Long id, String username) {
        userRepositoryImpl.save(User.builder()
                .id(id)
                .username(username)
                .build());
    }

    @Override
    public void update(UserDto userDto) {
        User user = mapToUser(userDto);
        userRepositoryImpl.update(user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getId());
    }

    @Override
    public UserDto findUserById(Long id) {
        return mapToDto(userRepositoryImpl.findById(id)
                .orElseThrow(()->new UserNotFoundException("No user found by id: " + id)));
    }

    @Override
    public boolean userExists(Long userid) {
        return userRepositoryImpl.existsById(userid);
    }

    @Override
    public User mapToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNumber(Long.parseLong(userDto.getPhoneNumber()))
                .locations(Arrays.asList(userDto.getLocationDto() != null ?
                        Location.builder()
                                .country(Country.builder().name(userDto.getLocationDto().getCountryName()).build())
                                .region(Region.builder().name(userDto.getLocationDto().getRegionName()).build())
                                .city(City.builder().name(userDto.getLocationDto().getCityName()).build())
                                .nativeRegion(Region.builder().name(userDto.getNativeRegion()).build())
                                .longitude(userDto.getLocationDto().getLongitude())
                                .latitude(userDto.getLocationDto().getLatitude())
                                .build()
                        : null))
                .possibilities(userDto.getPossibilities() != null ?
                        userDto.getPossibilities()
                                .stream()
                                .collect(()-> new ArrayList<Possibility>(),
                                        (list, item) -> list.add(new Possibility(item)),
                                        (list1, list2)-> list1.addAll(list2))
                        : null
                )
                .tasks(userDto.getTasks() != null ?
                        userDto.getTasks()
                                .stream()
                                .collect(()-> new ArrayList<Task>(),
                                        (list, item) -> list.add(new Task(item)),
                                        (list1, list2)-> list1.addAll(list2))
                        : null
                )
                .build();
    }

    @Override
    public UserDto mapToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(Long.toString(user.getPhoneNumber()))
                .locationDto(user.getLocations() != null ?
                        LocationDto.builder()
                                .countryName(user.getLocations().get(0).getCountry() != null ?
                                        user.getLocations().get(0).getCountry().getName()
                                        : null)
                                .regionName(user.getLocations().get(0).getRegion() != null ?
                                        user.getLocations().get(0).getRegion().getName()
                                        : null)
                                .cityName(user.getLocations().get(0).getCity() != null ?
                                        user.getLocations().get(0).getCity().getName()
                                        : null)
                                .longitude(user.getLocations().get(0).getLongitude())
                                .latitude(user.getLocations().get(0).getLatitude())
                                .build()
                        : null)
                .nativeRegion(user.getLocations() != null
                        ? user.getLocations().get(0).getNativeRegion() != null
                        ? user.getLocations().get(0).getNativeRegion().getName()
                        : null
                        : null)
                .possibilities(user.getPossibilities()
                        .stream()
                        .collect(()-> new ArrayList<String>(),
                                (list, item) -> list.add(item.getText()),
                                (list1, list2)-> list1.addAll(list2))
                )
                .tasks(user.getTasks()
                        .stream()
                        .collect(()-> new ArrayList<String>(),
                                (list, item) -> list.add(item.getText()),
                                (list1, list2)-> list1.addAll(list2))
                )
                .build();
    }

}

