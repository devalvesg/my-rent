package com.devalvesg.my_rent.Domain.Mappers;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Domain.RequestDTO.UserRequest;
import com.devalvesg.my_rent.Domain.ResponseDTO.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OutputMapping {

    UserEntity mapUserToEntity(UserRequest request);
    UserResponse mapUserToResponse(UserEntity entity);

}
