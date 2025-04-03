package com.devalvesg.my_rent.Infrastructure.Security;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import com.devalvesg.my_rent.Infrastructure.Repositories.Contract.ILessorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    ILessorRepository repository;
    public CustomUserDetailsService (ILessorRepository repository){
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
