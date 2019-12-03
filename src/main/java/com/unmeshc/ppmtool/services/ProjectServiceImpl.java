package com.unmeshc.ppmtool.services;

import com.unmeshc.ppmtool.domain.Project;
import com.unmeshc.ppmtool.exceptions.ProjectIdException;
import com.unmeshc.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by uc on 12/2/2019
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveOrUpdateProject(Project project) {
        String projectIdentifier = null;
        try {
            projectIdentifier = project.getProjectIdentifier().toUpperCase();
            project.setProjectIdentifier(projectIdentifier);
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + projectIdentifier +
                    "' already exists");
        }
    }

    @Override
    public Project getProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project ID '" + projectIdentifier +
                    "' does not exist");
        }
        return project;
    }

    @Override
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier);
        if (project == null) {
            throw new ProjectIdException("Couldn't delete the project with ID '" +
                    projectIdentifier + "'. The project doesn't exist.");
        }
        projectRepository.delete(project);
    }
}
