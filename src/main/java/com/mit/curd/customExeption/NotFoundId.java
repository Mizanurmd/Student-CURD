package com.mit.curd.customExeption;

public class NotFoundId extends RuntimeException  {
    public NotFoundId(String message){
        super(message);
    }
}
