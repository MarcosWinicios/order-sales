package com.studies.exceptions;

public class InvalidItemQuantity extends RuntimeException {

    public InvalidItemQuantity() {
        super("A quantidade deve ser maior que zero");
    }
}
