package ecare.local.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotNull @NotBlank
    private String login;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
    private String fistName;
    private String lastName;
    private Date birthday;
    @Column(unique=true)
    private String passport;
    private String address;
    @Column(unique=true)
    private String email;
    private String password;
}
