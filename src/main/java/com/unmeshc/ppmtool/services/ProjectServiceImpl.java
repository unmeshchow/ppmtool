package com.unmeshc.ppmtool.services;

import com.unmeshc.ppmtool.domain.Project;
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
        return projectRepository.save(project);
    }
}
