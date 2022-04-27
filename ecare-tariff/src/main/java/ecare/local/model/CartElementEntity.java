package ecare.local.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

// Todo: equals and hashcode for every entity
// https://www.sourcecodeexamples.net/2021/06/spring-boot-hibernate-dao-with-mysql.html

@Entity
@Table(name="cart_element")
@Data
public class CartElementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @NotNull
    private ContractEntity contractEntity;
    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private TariffAssignEntity tariffAssignEntity;
    private Date tariffStartDate;
    @ManyToOne
    @JoinColumn(name = "tariff_option_id")
    private TariffOptionEntity tariffOptionEntity;
    private Date tariffOptionStartDate;
    private Date tariffOptionEndDate;
}
