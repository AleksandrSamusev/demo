package MyExample1.demo.service;

import MyExample1.demo.dto.AddressDto;
import MyExample1.demo.dto.AddressShortDto;
import MyExample1.demo.exception.AddressNotFoundException;
import MyExample1.demo.exception.UserNotFoundException;
import MyExample1.demo.mapper.AddressMapper;
import MyExample1.demo.mapper.UserMapper;
import MyExample1.demo.repository.AddressRepository;
import MyExample1.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddressDto createAddressByUserId(AddressDto addressDto, Long userId) {
        validateUserId(userId);
        addressDto.setUserDto(UserMapper.toUserDto(userRepository.findById(userId).get()));
        return AddressMapper.toAddressDto(addressRepository.save(AddressMapper.toAddress(addressDto)));
    }

    @Override
    public List<AddressShortDto> getAddressByUserId(Long userId) {
        validateUserId(userId);
        return AddressMapper.toAddressShortDtos(addressRepository.getAddressesByUserId(userId));
    }

    @Override
    public void deleteAddressById(Long addressId) {
        validateAddressId(addressId);
        addressRepository.deleteById(addressId);
    }

    @Override
    public Iterable<AddressShortDto> getAllAddresses() {
        return AddressMapper.toAddressShortDtos(addressRepository.findAll());
    }

    private void validateAddressId(Long addressId) {
        if (!addressRepository.existsById(addressId)) {
            log.info("Address with id = {} not found", addressId);
            throw new AddressNotFoundException("Address not found");
        }
    }

    private void validateUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            log.info("User with id = {} not found", userId);
            throw new UserNotFoundException("User not found");
        }
    }

}
