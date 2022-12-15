package com.fmsshr.fmssdemohr.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralException extends ResponseEntityExceptionHandler {
    @Override
            protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                          HttpStatus status, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{

        String fieldName =((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName,errorMessage);
    });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> EmployeeNotFoundExceptionHandler(EmployeeNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeExpenseNotFoundException.class)
    public ResponseEntity<?> EmployeeExpenseNotFoundExceptionHandler(EmployeeExpenseNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeePermissionNotFoundException.class)
    public ResponseEntity<?> EmployeePermissionNotFoundExceptionHandler(EmployeePermissionNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
