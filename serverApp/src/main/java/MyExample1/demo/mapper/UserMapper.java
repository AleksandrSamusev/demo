package MyExample1.demo.mapper;

import MyExample1.demo.dto.UserDto;
import MyExample1.demo.dto.UserFullDto;
import MyExample1.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }

    public static UserFullDto toUserFullDto(User user) {
        UserFullDto userFullDto = new UserFullDto();
        userFullDto.setUserId(user.getUserId());
        userFullDto.setFirstName(user.getFirstName());
        userFullDto.setLastName(user.getLastName());
        userFullDto.setEmail(user.getEmail());
        userFullDto.setPhoneNumber(user.getPhoneNumber());
        return userFullDto;
    }

    public static User toUserFromFull(UserFullDto userFullDto) {
        User user = new User();
        user.setUserId(userFullDto.getUserId());
        user.setFirstName(userFullDto.getFirstName());
        user.setLastName(userFullDto.getLastName());
        user.setEmail(userFullDto.getEmail());
        user.setPhoneNumber(userFullDto.getPhoneNumber());
        return user;
    }

    public static List<User> toUsers(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            users.add(toUser(userDto));
        }
        return users;
    }

    public static List<UserDto> toUserDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(toUserDto(user));
        }
        return userDtos;
    }

    public static List<UserFullDto> toUserFullDtos(List<User> users) {
        List<UserFullDto> userFullDtos = new ArrayList<>();
        for (User user : users) {
            userFullDtos.add(toUserFullDto(user));
        }
        return userFullDtos;
    }
}
