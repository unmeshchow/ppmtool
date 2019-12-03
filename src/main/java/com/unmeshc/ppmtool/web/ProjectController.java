package com.unmeshc.ppmtool.web;

import com.unmeshc.ppmtool.domain.Project;
import com.unmeshc.ppmtool.services.ErrorResponseService;
import com.unmeshc.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by uc on 12/2/2019
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ErrorResponseService errorResponseService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,
                                              BindingResult result) {
        ResponseEntity<?> errorMap = errorResponseService.getValidationErrorMap(result);
        if (errorMap != null) return errorMap;

        return new ResponseEntity<>(projectService.saveOrUpdateProject(project),
                HttpStatus.CREATED);
    }

    @PutMapping("/{projectIdentifier}")
    public ResponseEntity<?> updateProjectByIdentifier(@PathVariable String projectIdentifier,
                                                       @Valid @RequestBody Project project,
                                                       BindingResult result) {
        ResponseEntity<?> errorMap = errorResponseService.getValidationErrorMap(result);
        if (errorMap != null) return errorMap;

        Project foundProject = projectService.getProjectByIdentifier(projectIdentifier);
        project.setId(foundProject.getId());

        return new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.OK);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectIdentifier) {
        Project project = projectService.getProjectByIdentifier(projectIdentifier);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{projectIdentifier}")
    public ResponseEntity<?> deleteProjectByIdentifier(@PathVariable String projectIdentifier) {
        projectService.deleteProjectByIdentifier(projectIdentifier);

        return new ResponseEntity<>("Project with ID '" + projectIdentifier +
                "' was deleted.", HttpStatus.OK);
    }
}
