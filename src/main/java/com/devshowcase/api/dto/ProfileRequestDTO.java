package com.devshowcase.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileRequestDTO {

    @NotBlank(message = "O nome não pode estar vazio")
    private String name;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "Formato de email inválido")
    private String email;

    private String bio;
}