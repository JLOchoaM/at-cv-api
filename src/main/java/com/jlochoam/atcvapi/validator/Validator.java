package com.jlochoam.atcvapi.validator;

public interface Validator<E> {
    void validate(E object);
}