package com.devalvesg.my_rent.Application.UseCase;

import com.devalvesg.my_rent.Application.UseCase.Contracts.ICreateUserUseCase;
import com.devalvesg.my_rent.Application.UseCase.Contracts.IExistsUserUseCase;
import com.devalvesg.my_rent.Domain.Contracts.IUserRepository;
import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Domain.ResponseDTO.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements ICreateUserUseCase {

    private IUserRepository userRepository;

    public CreateUserUseCase(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserEntity username) {
        return userRepository.save(username);
    }
}
