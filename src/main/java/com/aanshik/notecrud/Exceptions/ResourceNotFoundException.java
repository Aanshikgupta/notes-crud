package com.aanshik.notecrud.Exceptions;

public class ResourceNotFoundException extends RuntimeException{




    public ResourceNotFoundException(String resource, int value) {
        super(resource+" not found with id = "+value);
    }
}
