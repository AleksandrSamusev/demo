package MyExample1.demo.mapper;

import MyExample1.demo.dto.AddressDto;
import MyExample1.demo.dto.AddressShortDto;
import MyExample1.demo.model.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {
    public static Address toAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setAddress_id(addressDto.getAddress_id());
        address.setUser(UserMapper.toUser(addressDto.getUserDto()));
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setFlatNumber(addressDto.getFlatNumber());
        return address;
    }

    public static AddressDto toAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress_id(address.getAddress_id());
        addressDto.setUserDto(UserMapper.toUserDto(address.getUser()));
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setFlatNumber(address.getFlatNumber());
        return addressDto;
    }

    public static AddressShortDto toAddressShortDto(Address address) {
        AddressShortDto addressShortDto = new AddressShortDto();
        addressShortDto.setAddress_id(address.getAddress_id());
        addressShortDto.setCountry(address.getCountry());
        addressShortDto.setCity(address.getCity());
        addressShortDto.setStreet(address.getStreet());
        addressShortDto.setHouseNumber(address.getHouseNumber());
        addressShortDto.setFlatNumber(address.getFlatNumber());
        return addressShortDto;
    }

    public static List<AddressShortDto> toAddressShortDtos(List<Address> addresses) {
        List<AddressShortDto> addressShortDtos = new ArrayList<>();
        for (Address address : addresses) {
            addressShortDtos.add(toAddressShortDto(address));
        }
        return addressShortDtos;
    }

    public static List<Address> toAddresses(List<AddressDto> addressDtos) {
        List<Address> addresses = new ArrayList<>();
        for (AddressDto addressDto : addressDtos) {
            addresses.add(toAddress(addressDto));
        }
        return addresses;
    }

    public static List<AddressDto> toAddressDtos(List<Address> addresses) {
        List<AddressDto> addressDtos = new ArrayList<>();
        for (Address address : addresses) {
            addressDtos.add(toAddressDto(address));
        }
        return addressDtos;
    }
}
