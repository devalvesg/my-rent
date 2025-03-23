package com.devalvesg.my_rent.Infrastructure.Controllers;

import com.devalvesg.my_rent.Application.UseCase.CreateUserUseCase;
import com.devalvesg.my_rent.Domain.Mappers.OutputMapping;
import com.devalvesg.my_rent.Domain.RequestDTO.LoginRequest;
import com.devalvesg.my_rent.Domain.RequestDTO.UserRequest;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final OutputMapping mapper;
    private final CreateUserUseCase createUserUseCase;

    public AuthController(AuthenticationManager authenticationManager, OutputMapping mapper, CreateUserUseCase createUserUseCase) {
        this.authenticationManager = authenticationManager;
        this.mapper = mapper;
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginData) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok(auth);
    }

    @SneakyThrows
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRequest registerData) {
        var response = createUserUseCase.createUser(mapper.mapUserToEntity(registerData));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapUserToResponse(response));
    }
}
