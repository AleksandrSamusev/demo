package MyExample1.demo.mapper;

import MyExample1.demo.dto.AddressDto;
import MyExample1.demo.model.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {
    public static Address toAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setAddress_id(addressDto.getAddress_id());
        address.setUser(addressDto.getUser());
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
        addressDto.setUser(address.getUser());
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setFlatNumber(address.getFlatNumber());
        return addressDto;
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
