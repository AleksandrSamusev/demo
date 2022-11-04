package MyExample1.demo.mapper;

import MyExample1.demo.dto.UserDto;
import MyExample1.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setAddresses(userDto.getAddresses());
        user.setEmail(userDto.getEmail());
        user.setOrders(userDto.getOrders());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setAddresses(user.getAddresses());
        userDto.setEmail(user.getEmail());
        userDto.setOrders(user.getOrders());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
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
}
