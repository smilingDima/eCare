package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="tariff")
@Data
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotNull @NotBlank
    private String name;
    @NotNull
    private long price;

    // https://stackoverflow.com/questions/42394095/many-to-many-relationship-between-two-entities-in-spring-boot
    @ManyToMany(mappedBy = "tariffs")
    private Set<TariffOptionEntity> tariffOptions;
}
