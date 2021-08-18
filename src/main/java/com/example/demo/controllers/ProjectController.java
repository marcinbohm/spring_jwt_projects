package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/services/projectslist")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public void addProject(@Valid @RequestBody Project project) {
        projectService.addProject(project);
    }

    @PutMapping
    public void updateProject(@Valid @RequestBody Project project) {
        projectService.updateProject(project);
    }

    @DeleteMapping(path = "{projectId}")
    public void deleteProject(
            @PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
    }
}
