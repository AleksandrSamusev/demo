package MyExample1.demo.dto;

import MyExample1.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Long address_id;
    private User user;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
}
