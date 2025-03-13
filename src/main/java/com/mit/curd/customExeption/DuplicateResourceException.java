package com.mit.curd.customExeption;

public class DuplicateResourceException extends RuntimeException {

    public  DuplicateResourceException(String message){
        super(message);
    }
}
