package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Project;
import com.examly.springapp.repository.ProjectRepo;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project project = projectRepo.findById(id).orElse(null);
        if (project != null) {
            project.setProjectName(updatedProject.getProjectName());
            project.setDescription(updatedProject.getDescription());
            project.setStatus(updatedProject.getStatus());
            return projectRepo.save(project);
        }
        return null;
    }

    public List<Project> getProjectsByStatus(String status) {
        return projectRepo.findByStatus(status);
    }
}
