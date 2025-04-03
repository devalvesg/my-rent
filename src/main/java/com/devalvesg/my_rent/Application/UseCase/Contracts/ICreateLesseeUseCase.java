package com.devalvesg.my_rent.Application.UseCase.Contracts;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;

public interface ICreateLesseeUseCase {
    UserEntity createLessee(UserEntity username) throws Exception;
}
