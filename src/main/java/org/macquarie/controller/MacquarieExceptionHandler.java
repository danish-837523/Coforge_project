package org.macquarie.controller;

import org.macquarie.constants.LogConstants;
import org.macquarie.constants.MacquarieConstants;
import org.macquarie.exceptions.MacquaireException;
import org.macquarie.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MacquarieExceptionHandler {

    @ExceptionHandler(MacquaireException.class)
    public ResponseEntity<ErrorResponse> handleMacquaireException(WebRequest web, MacquaireException ex){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ex.getCode());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(ex.getHttpStatus());
        errorResponse.setTraceId(web.getHeader(MacquarieConstants.TRACE_ID));
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getHttpStatus()));
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleMissingHeader(WebRequest web,MissingRequestHeaderException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(LogConstants.MANDATORY_HEADER_MISSING.getCode());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTraceId(web.getHeader(MacquarieConstants.TRACE_ID));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generalException(WebRequest web, Exception ex){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(LogConstants.INTERNAL_SERVER_ERROR.getCode());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setTraceId(web.getHeader(MacquarieConstants.TRACE_ID));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
