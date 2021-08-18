package com.example.demo.services;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ProjectNotFoundException;
import com.example.demo.models.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void addProject(Project project) {
        Boolean existsProject = projectRepository
                .selectExistsProject(project.getId());
        if (existsProject) {
            throw new BadRequestException(
                    "Project " + project.getId() + " already exists");
        }

        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        if(!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException(
                    "Project with id " + projectId + " does not exists");
        }
        projectRepository.deleteById(projectId);
    }

    public void updateProject(Project project) {
        if(!projectRepository.existsById(project.getId())) {
            throw new ProjectNotFoundException(
                    "Project with id " + project.getId() + " does not exists");
        }

        projectRepository.updateProject(project.getId(),
                project.getName(),
                project.getProjectNo(),
                project.getProjectCode());
    }
}