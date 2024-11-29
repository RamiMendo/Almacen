package com.ramitax.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleEntityException(CustomException ex, WebRequest request){
        String mensaje = ex.getMessage();
        return handleExceptionInternal(ex, mensaje, new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @ExceptionHandler(value = {SQLException.class})
    public ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest request){
        String mensaje = ex.getMessage();
        return handleExceptionInternal(ex, mensaje, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
