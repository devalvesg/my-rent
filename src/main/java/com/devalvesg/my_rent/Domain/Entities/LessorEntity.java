package com.devalvesg.my_rent.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Lessors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessorEntity extends UserEntity {

    public LessorEntity (UserEntity user){
        setEmail(user.getEmail());
        setDocument(user.getDocument());
        setPassword(user.getPassword());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setPhone(user.getPhone());
    }

    @OneToMany(mappedBy = "lessor")
    private List<PropertyEntity> properties;

    @OneToMany(mappedBy = "lessor")
    private List<ContractEntity> contracts;
}
