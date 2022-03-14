package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class TariffOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotNull @NotBlank
    private String name;
    @NotNull
    private Long price;
    @NotNull
    private Long enablingPrice;

    @ManyToMany
    @JoinTable
    private Set<Tariff> tariffs;

    @ManyToMany
    @JoinTable
    private Set<TariffOption> incompatibleTariffOptions;

    @ManyToMany
    @JoinTable
    private Set<TariffOption> connectedTariffOptions;
}
