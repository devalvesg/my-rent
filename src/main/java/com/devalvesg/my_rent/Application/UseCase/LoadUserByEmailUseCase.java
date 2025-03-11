package com.devalvesg.my_rent.Application.UseCase;

import com.devalvesg.my_rent.Application.UseCase.Contracts.ILoadUserByEmailUseCase;
import com.devalvesg.my_rent.Domain.Contracts.IUserRepository;
import com.devalvesg.my_rent.Domain.Details.UserDetailsImp;
import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoadUserByEmailUseCase implements ILoadUserByEmailUseCase {

    private IUserRepository userRepository;

    public LoadUserByEmailUseCase(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UserDetailsImp(user);
    }
}
