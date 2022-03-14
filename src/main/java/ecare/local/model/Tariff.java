package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotNull @NotBlank
    private String name;
    @NotNull
    private Long price;

    // https://stackoverflow.com/questions/42394095/many-to-many-relationship-between-two-entities-in-spring-boot
    @ManyToMany(mappedBy = "tariffs")
    private Set<TariffOption> tariffOptions;
}
