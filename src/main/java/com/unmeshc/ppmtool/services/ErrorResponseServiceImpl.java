package com.unmeshc.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uc on 12/2/2019
 */
@Service
public class ErrorResponseServiceImpl implements ErrorResponseService {

    @Override
    public ResponseEntity<?> getValidationErrorMap(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> mapErrors = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                mapErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(mapErrors, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
