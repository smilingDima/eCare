package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotNull @NotBlank
    private String name;
    @NotNull
    private int level; // 1 - Admin, 2 - Manager, 3 - Customer
}
