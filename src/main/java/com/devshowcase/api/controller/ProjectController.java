package com.devshowcase.api.controller;

import com.devshowcase.api.dto.ProjectRequestDTO;
import com.devshowcase.api.model.Profile;
import com.devshowcase.api.model.Project;
import com.devshowcase.api.model.Technology;
import com.devshowcase.api.repository.ProfileRepository;
import com.devshowcase.api.repository.ProjectRepository;
import com.devshowcase.api.repository.TechnologyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @PostMapping
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectRequestDTO dto) {
        Optional<Profile> profileOpt = profileRepository.findById(dto.getProfileId());
        if (!profileOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Perfil não encontrado com o ID informado.");
        }

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setProjectUrl(dto.getProjectUrl());
        project.setProfile(profileOpt.get());

        if (dto.getTechnologyIds() != null && !dto.getTechnologyIds().isEmpty()) {
            List<Technology> techs = technologyRepository.findAllById(dto.getTechnologyIds());
            project.setTechnologies(techs);
        }

        Project saved = projectRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return ResponseEntity.ok(projects);
    }
}