package com.example.demo.component.validation;

import com.example.demo.component.exception.ValidateException;

public interface FormValidator<T> {

    boolean canAccept(T arg);

    void validate(T arg) throws ValidateException;
}
