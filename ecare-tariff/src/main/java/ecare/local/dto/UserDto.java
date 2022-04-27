package ecare.local.dto;

import ecare.local.model.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public final class UserDto {
    private Long id;
    private String login;
    private RoleEntity role;
    private String fistName;
    private String lastName;
    private Date birthday;
    private String passport;
    private String address;
    private String email;
    private String password;
}
