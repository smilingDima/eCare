package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class TariffOptionAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @NotNull
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "tariff_option_id")
    @NotNull
    private TariffOption tariffOption;
    @NotNull
    private Date startDate;
    private Date endDate;
}
