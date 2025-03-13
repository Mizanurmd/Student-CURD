package com.mit.curd.customExeption;

public class CountryNotFoundException extends  RuntimeException{

    public  CountryNotFoundException(String message){
        super(message);

    }
}
