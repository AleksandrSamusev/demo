package MyExample1.demo.controller;

import MyExample1.demo.dto.AddressDto;
import MyExample1.demo.dto.AddressShortDto;
import MyExample1.demo.service.AddressServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/addresses")
public class AddressController {
    private final AddressServiceImpl addressService;

    @Autowired
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{userId}")
    AddressDto createAddressByUserId(@RequestBody AddressDto addressDto, @PathVariable Long userId) {
        return addressService.createAddressByUserId(addressDto, userId);
    }

    @GetMapping("/{userId}")
    List<AddressShortDto> getAddressByUserId(@PathVariable Long userId) {
        return addressService.getAddressByUserId(userId);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddressById(@PathVariable Long addressId) {
        addressService.deleteAddressById(addressId);
    }

}
