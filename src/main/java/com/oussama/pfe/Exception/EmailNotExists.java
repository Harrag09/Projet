package com.oussama.pfe.Exception;

public class EmailNotExists extends RuntimeException {


    public EmailNotExists(String message) {
        super(message);
    }
}