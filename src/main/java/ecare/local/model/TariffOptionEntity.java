package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="tariff_option")
@Data
public class TariffOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotNull @NotBlank
    private String name;
    @NotNull
    private long price;
    @NotNull
    private long enablingPrice;

    @ManyToMany
    @JoinTable
    private Set<TariffAssignEntity> tariffs;

    @ManyToMany
    @JoinTable
    private Set<TariffOptionEntity> incompatibleTariffOptions;

    @ManyToMany
    @JoinTable
    private Set<TariffOptionEntity> connectedTariffOptions;
}
