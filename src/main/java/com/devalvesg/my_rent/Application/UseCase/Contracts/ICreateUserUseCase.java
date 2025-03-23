package com.devalvesg.my_rent.Application.UseCase.Contracts;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Domain.ResponseDTO.UserResponse;

public interface ICreateUserUseCase {

    UserResponse createUser(UserEntity username);
}
