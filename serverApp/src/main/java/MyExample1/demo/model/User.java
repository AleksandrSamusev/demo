package MyExample1.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "phone_number")
    @Pattern(regexp = "^\\d{10}$", message = "10 digits number expected")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;


}
