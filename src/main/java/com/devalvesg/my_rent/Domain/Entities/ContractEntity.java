package com.devalvesg.my_rent.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "Contracts")
@Data
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lessor_id")
    private LessorEntity lessor;
    @ManyToOne
    @JoinColumn(name = "lessee_id")
    private LesseeEntity lessee;
    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;
    private String contractIdentifier;
    private double monthlyAmount;
    private int rentDueDate;
    private LocalDateTime startContractDate;
    private LocalDateTime endContractDate;
}
