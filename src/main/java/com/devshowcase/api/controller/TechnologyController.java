package com.devshowcase.api.controller;

import com.devshowcase.api.dto.TechnologyRequestDTO;
import com.devshowcase.api.model.Technology;
import com.devshowcase.api.repository.TechnologyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    @Autowired
    private TechnologyRepository technologyRepository;

    @PostMapping
    public ResponseEntity<Technology> createTechnology(@Valid @RequestBody TechnologyRequestDTO dto) {
        Technology tech = new Technology();
        tech.setName(dto.getName());
        
        Technology saved = technologyRepository.save(tech);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Technology>> getAllTechnologies() {
        List<Technology> list = technologyRepository.findAll();
        return ResponseEntity.ok(list);
    }
}