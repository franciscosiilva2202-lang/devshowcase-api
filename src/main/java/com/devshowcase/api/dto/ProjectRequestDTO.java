package com.devshowcase.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.util.List;

@Data
public class ProjectRequestDTO {

    @NotBlank(message = "O título do projeto não pode estar vazio")
    private String title;

    private String description;

    @NotBlank(message = "A URL do projeto é obrigatória")
    @Pattern(regexp = "^(https?|ftp)://(-\\.)?([^\\s/?\\.#-]+\\.?)+(/[^\\s]*)?$", message = "URL inválida")
    private String projectUrl;

    @NotNull(message = "O ID do perfil é obrigatório")
    private Long profileId;

    private List<Long> technologyIds;
}