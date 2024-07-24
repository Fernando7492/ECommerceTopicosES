package com.topicos.catalog.controllers;

public class DuplicatedRegisterException  extends RuntimeException{
        public DuplicatedRegisterException(String msg){
        super(msg);
    }
}
