package com.devalvesg.my_rent.Application.UseCase.Contracts;

import org.springframework.security.core.userdetails.UserDetails;

public interface ILoadUserByEmailUseCase {

    UserDetails loadUserByUsername(String username);
}
