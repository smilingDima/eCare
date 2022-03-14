package ecare.local.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ecare.local.model.Role;
import ecare.local.model.User;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public final class UserDTO {
    private Long id;
    @JsonProperty("login")
    private String login;
    private Role role;
    @JsonProperty("fistName")
    private String fistName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("birthday")
    private Date birthday;
    @JsonProperty("passport")
    private String passport;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public User asEntity() {
        return new User(
                this.id,
                this.login,
                this.role,
                this.fistName,
                this.lastName,
                this.birthday,
                this.passport,
                this.address,
                this.email,
                this.password
        );
    }
}
