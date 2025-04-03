package com.devalvesg.my_rent.Infrastructure.Repositories.Contract;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;

import java.util.Optional;

public interface IUserRepository{

    UserEntity findByEmail(String email);
}
