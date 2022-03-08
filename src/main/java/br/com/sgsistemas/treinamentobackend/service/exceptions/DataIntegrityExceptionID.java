package br.com.sgsistemas.treinamentobackend.service.exceptions;

public class DataIntegrityExceptionID extends RuntimeException{

    public DataIntegrityExceptionID(String message) {
        super(message);
    }

    public DataIntegrityExceptionID(String message, Throwable cause) {
        super(message, cause);
    }
}
