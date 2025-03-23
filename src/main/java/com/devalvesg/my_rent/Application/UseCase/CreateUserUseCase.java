package com.devalvesg.my_rent.Application.UseCase;

import com.devalvesg.my_rent.Application.UseCase.Contracts.ICreateUserUseCase;
import com.devalvesg.my_rent.Domain.Contracts.IUserRepository;
import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Domain.Exceptions.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements ICreateUserUseCase {

    private IUserRepository userRepository;

    public CreateUserUseCase(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) throws Exception {
        userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new BusinessException("Usuário já existe no banco de dados"));
        return userRepository.save(user);
    }
}
