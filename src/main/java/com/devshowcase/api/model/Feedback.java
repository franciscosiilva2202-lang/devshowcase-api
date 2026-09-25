package com.devshowcase.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O comentário não pode estar vazio")
    private String comment;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}