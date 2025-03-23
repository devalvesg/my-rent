package com.devalvesg.my_rent.Domain.RequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(@NotBlank(message = "O email é obrigatório") @Email(message = "Email inválido") String email,
                          @NotBlank(message = "A senha é obrigatória") @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres") String password,
                          @NotBlank(message = "O nome é obrigatório") String firstName,
                          String lastName,
                          String phone,
                          @NotBlank(message = "O documento é obrigatório") String document) {
}
