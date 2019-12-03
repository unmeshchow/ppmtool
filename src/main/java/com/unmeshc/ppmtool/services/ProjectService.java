package com.unmeshc.ppmtool.services;

import com.unmeshc.ppmtool.domain.Project;

/**
 * Created by uc on 12/2/2019
 */
public interface ProjectService {

    Project saveOrUpdateProject(Project project);

    Project getProjectByIdentifier(String projectIdentifier);

    Iterable<Project> getAllProjects();

    void deleteProjectByIdentifier(String projectIdentifier);
}
