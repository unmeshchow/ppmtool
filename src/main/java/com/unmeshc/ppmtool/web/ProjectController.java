package com.unmeshc.ppmtool.web;

import com.unmeshc.ppmtool.domain.Project;
import com.unmeshc.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uc on 12/2/2019
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        return new ResponseEntity<>(projectService.saveOrUpdateProject(project),
                HttpStatus.CREATED);
    }
}
