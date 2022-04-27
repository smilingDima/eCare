package ecare.local.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="contract")
@Data
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "blocked_by_id")
    private RoleEntity blockedBy;
}
