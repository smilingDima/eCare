package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class TariffAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @NotNull
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "tariff_id")
    @NotNull
    private Tariff tariff;
    @NotNull
    private Date start_date;
}
