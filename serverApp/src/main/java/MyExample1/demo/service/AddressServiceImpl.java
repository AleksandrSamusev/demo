package MyExample1.demo.service;

import MyExample1.demo.dto.AddressDto;
import MyExample1.demo.dto.AddressShortDto;
import MyExample1.demo.mapper.AddressMapper;
import MyExample1.demo.mapper.UserMapper;
import MyExample1.demo.repository.AddressRepository;
import MyExample1.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddressDto createAddressByUserId(AddressDto addressDto, Long userId) {
        addressDto.setUserDto(UserMapper.toUserDto(userRepository.findById(userId).get()));
        return AddressMapper.toAddressDto(addressRepository.save(AddressMapper.toAddress(addressDto)));
    }

    @Override
    public List<AddressShortDto> getAddressByUserId(Long userId) {
        return AddressMapper.toAddressShortDtos(addressRepository.getAddressesByUserId(userId));
    }
}
