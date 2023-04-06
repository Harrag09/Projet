package com.oussama.pfe.Exception;

public class PasswordNotCorrect extends RuntimeException {

    public PasswordNotCorrect(String message) {
        super(message);
    }
}