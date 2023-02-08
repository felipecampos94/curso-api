package br.com.java.api.service.exception;

public class DataIntegrityViolationdException extends RuntimeException {

    public DataIntegrityViolationdException(String message) {
        super(message);
    }

}
