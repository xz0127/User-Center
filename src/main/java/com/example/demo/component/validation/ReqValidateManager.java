package com.example.demo.component.validation;

import com.example.demo.component.exception.ValidateException;

public interface ReqValidateManager<T> {
    void doExecute(T arg) throws ValidateException;
}
