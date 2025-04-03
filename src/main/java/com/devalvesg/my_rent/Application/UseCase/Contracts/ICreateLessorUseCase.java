package com.devalvesg.my_rent.Application.UseCase.Contracts;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;

public interface ICreateLessorUseCase {
    UserEntity createLessor(UserEntity username) throws Exception;
}
