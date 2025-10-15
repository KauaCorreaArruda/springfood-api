package com.kauacorreaarruda.springfood.domain.exception;

public class EntityNotAvailableException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntityNotAvailableException(String message) {
        super(message);
    }
}
