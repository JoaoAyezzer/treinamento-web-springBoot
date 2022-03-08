package br.com.sgsistemas.treinamentobackend.controllers.exception;

import br.com.sgsistemas.treinamentobackend.service.exceptions.DataIntegrityException;
import br.com.sgsistemas.treinamentobackend.service.exceptions.DataIntegrityExceptionID;
import br.com.sgsistemas.treinamentobackend.service.exceptions.ObjectNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerService {

    @ExceptionHandler(ObjectNotfoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotfoundException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(DataIntegrityExceptionID.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityExceptionID e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
