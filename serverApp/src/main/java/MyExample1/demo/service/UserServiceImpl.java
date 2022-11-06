package MyExample1.demo.service;

import MyExample1.demo.dto.UserDto;
import MyExample1.demo.dto.UserFullDto;
import MyExample1.demo.exception.UserNotFoundException;
import MyExample1.demo.mapper.AddressMapper;
import MyExample1.demo.mapper.OrderMapper;
import MyExample1.demo.mapper.UserMapper;
import MyExample1.demo.model.User;
import MyExample1.demo.repository.AddressRepository;
import MyExample1.demo.repository.OrderRepository;
import MyExample1.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("User created.");
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userDto)));
    }

    @Override
    public List<UserFullDto> getUsers() {
        List<UserFullDto> dtos = UserMapper.toUserFullDtos(userRepository.findAll());
        for (UserFullDto userFullDto : dtos) {
            userFullDto.setAddressShortDtos(AddressMapper.toAddressShortDtos(addressRepository
                    .getAddressesByUserId(userFullDto.getUserId())));
            userFullDto.setOrderDtos((OrderMapper.toOrderDtos(orderRepository
                    .getOrdersByUserId(userFullDto.getUserId()))));
        }
        return dtos;
    }

    @Override
    public void deleteUserById(Long userId) {
        validateUserId(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public UserFullDto getUserById(Long userId) {
        validateUserId(userId);
        UserFullDto user = UserMapper.toUserFullDto(userRepository.getReferenceById(userId));
        user.setAddressShortDtos(AddressMapper.toAddressShortDtos(addressRepository.getAddressesByUserId(userId)));
        user.setOrderDtos(OrderMapper.toOrderDtos(orderRepository.getOrdersByUserId(userId)));
        return user;
    }

    @Override
    public UserDto updateUserById(Long userId, UserDto userDto) {
        if (userRepository.existsById(userId)) {
            User user = new User();
            if (userDto.getEmail() != null) {
                user.setEmail(userDto.getEmail());
            }
            if (userDto.getFirstName() != null) {
                user.setFirstName(userDto.getFirstName());
            }
            if (userDto.getLastName() != null) {
                user.setLastName(userDto.getLastName());
            }
            if (userDto.getPhoneNumber() != null) {
                user.setPhoneNumber(userDto.getPhoneNumber());
            }
            return UserMapper.toUserDto(userRepository.save(user));
        }
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userDto)));
    }

    private void validateUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            log.info("User with id={} not found", userId);
            throw new UserNotFoundException("User not found");

        }
    }

}
