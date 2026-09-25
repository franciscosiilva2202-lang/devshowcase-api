package com.devshowcase.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TechnologyRequestDTO {

    @NotBlank(message = "O nome da tecnologia não pode estar vazio")
    private String name;
}