package MyExample1.demo.service;

import MyExample1.demo.dto.UserDto;
import MyExample1.demo.mapper.UserMapper;
import MyExample1.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("User created.");
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userDto)));
    }

}
