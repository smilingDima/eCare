package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="tariff_assign")
@Data
public class TariffAssignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @NotNull
    private ContractEntity contractEntity;
    @ManyToOne
    @JoinColumn(name = "tariff_id")
    @NotNull
    private TariffEntity tariffEntity;
    @NotNull
    private Date start_date;
}
