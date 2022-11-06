package MyExample1.demo.service;

import MyExample1.demo.dto.AddressDto;
import MyExample1.demo.dto.AddressShortDto;

import java.util.List;

public interface AddressService {

    AddressDto createAddressByUserId(AddressDto addressDto, Long userId);

    List<AddressShortDto> getAddressByUserId(Long userId);

    void deleteAddressById(Long addressId);

    Iterable<AddressShortDto> getAllAddresses();

}
