package com.example.userCenter.component.validation;

import com.example.userCenter.component.exception.ValidateException;

public interface FormValidator<T> {

    boolean canAccept(T arg);

    void validate(T arg) throws ValidateException;
}
