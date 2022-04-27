package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="tariff_option_assign")
@Data
public class TariffOptionAssignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @NotNull
    private ContractEntity contract;
    @ManyToOne
    @JoinColumn(name = "tariff_option_id")
    @NotNull
    private TariffOptionEntity tariffOption;
    @NotNull
    private Date startDate;
    private Date endDate;
}
