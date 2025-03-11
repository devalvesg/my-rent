package com.devalvesg.my_rent.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Properties")
@Data
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lessor_id")
    private LessorEntity lessor;
    @OneToOne(mappedBy = "property")
    private ContractEntity contract;
    private int rooms;
    private int bathrooms;
    private int parkingSpaces;
    @Column(length = 300)
    private String description;
    private boolean isApartment;
    @Column(nullable = true)
    private int floor;
}
