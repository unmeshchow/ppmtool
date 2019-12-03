package com.unmeshc.ppmtool.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by uc on 12/2/2019
 */
@Getter
@Setter
public class ProjectIdExceptionResponse {

    private String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
