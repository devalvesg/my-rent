package com.devalvesg.my_rent.Infrastructure.Controllers;

import com.devalvesg.my_rent.Application.UseCase.Contracts.IExistsUserUseCase;
import com.devalvesg.my_rent.Domain.RequestDTO.LoginRequest;
import com.devalvesg.my_rent.Domain.RequestDTO.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final IExistsUserUseCase existsUserUseCase;

    public AuthController(AuthenticationManager authenticationManager, IExistsUserUseCase existsUserUseCase) {
        this.authenticationManager = authenticationManager;
        this.existsUserUseCase = existsUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginData) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequest registerData) {
        existsUserUseCase.existsUser(registerData.email()) ? return ResponseEntity.ok("Este email já existe") : ;



    }
}
