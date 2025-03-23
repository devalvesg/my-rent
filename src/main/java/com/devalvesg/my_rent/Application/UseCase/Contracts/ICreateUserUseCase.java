package com.devalvesg.my_rent.Application.UseCase.Contracts;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;

public interface ICreateUserUseCase {
    UserEntity createUser(UserEntity username) throws Exception;
}
