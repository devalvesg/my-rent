package com.devalvesg.my_rent.Application.UseCase;

import com.devalvesg.my_rent.Application.UseCase.Contracts.IExistsUserUseCase;
import com.devalvesg.my_rent.Domain.Contracts.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ExistsUserUseCase implements IExistsUserUseCase {

    private IUserRepository userRepository;

    public ExistsUserUseCase(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsUser(String username) {
        return userRepository.findByEmail(username).isPresent();
    }
}
