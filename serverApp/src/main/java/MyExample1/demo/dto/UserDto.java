package MyExample1.demo.dto;

import MyExample1.demo.model.Address;
import MyExample1.demo.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Address> addresses;
    private List<Order> orders;
}
