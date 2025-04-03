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

    public LesseeEntity (UserEntity user){
        setEmail(user.getEmail());
        setDocument(user.getDocument());
        setPassword(user.getPassword());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setPhone(user.getPhone());
    }

    @OneToMany(mappedBy = "lessee")
    private List<ContractEntity> contracts;
}
