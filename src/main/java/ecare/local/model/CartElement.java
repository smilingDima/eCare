package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class CartElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @NotNull
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;
    private Date tariffStartDate;
    @ManyToOne
    @JoinColumn(name = "tariff_option_id")
    private TariffOption tariffOption;
    private Date tariffOptionStartDate;
    private Date tariffOptionEndDate;
}
