package MyExample1.demo.service;

import MyExample1.demo.dto.UserDto;
import MyExample1.demo.dto.UserFullDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    Iterable<UserFullDto> getUsers();

    void deleteUserById(Long userId);

    UserFullDto getUserById(Long userId);

    UserDto updateUserById(Long userId, UserDto userDto);

}
