package com.devalvesg.my_rent.Infrastructure.Controllers;

import com.devalvesg.my_rent.Application.UseCase.Contracts.ICreateLesseeUseCase;
import com.devalvesg.my_rent.Application.UseCase.Contracts.ICreateLessorUseCase;
import com.devalvesg.my_rent.Application.UseCase.CreateLesseeUseCase;
import com.devalvesg.my_rent.Application.UseCase.CreateLessorUseCase;
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
    private final ICreateLessorUseCase createLessorUseCase;
    private final ICreateLesseeUseCase createLesseeUseCase;

    public AuthController(AuthenticationManager authenticationManager, OutputMapping mapper, ICreateLessorUseCase createLessorUseCase, ICreateLesseeUseCase createLesseeUseCase) {
        this.authenticationManager = authenticationManager;
        this.mapper = mapper;
        this.createLessorUseCase = createLessorUseCase;
        this.createLesseeUseCase = createLesseeUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginData) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok(auth);
    }

    @SneakyThrows
    @PostMapping("/register-lessor")
    public ResponseEntity registerLessor(@RequestBody @Valid UserRequest registerData) {
        var response = createLessorUseCase.createLessor(mapper.mapUserToEntity(registerData));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapUserToResponse(response));
    }

    @SneakyThrows
    @PostMapping("/register-lessee")
    public ResponseEntity registerLessee(@RequestBody @Valid UserRequest registerData) {
        var response = createLesseeUseCase.createLessee(mapper.mapUserToEntity(registerData));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapUserToResponse(response));
    }
}
