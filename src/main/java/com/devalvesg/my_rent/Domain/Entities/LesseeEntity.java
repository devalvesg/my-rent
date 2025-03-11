package com.devalvesg.my_rent.Domain.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Lessees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LesseeEntity extends UserEntity {

    @OneToMany(mappedBy = "lessee")
    private List<ContractEntity> contracts;
}
