package com.unmeshc.ppmtool.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * Created by uc on 12/2/2019
 */
public interface ErrorResponseService {
    ResponseEntity<?> getValidationErrorMap(BindingResult result);
}
