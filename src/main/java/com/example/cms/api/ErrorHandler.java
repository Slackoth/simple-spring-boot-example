package com.example.cms.api;

import com.example.cms.exception.ApplicationError;
import com.example.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
//  Access spring property
    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFound(CustomerNotFoundException ex, WebRequest req) {
        ApplicationError error = new ApplicationError();

        error.setCode(404);
        error.setMessage(ex.getMessage());
        error.setDetails(this.details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
