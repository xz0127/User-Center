package com.example.userCenter.component.validation;

import com.example.userCenter.component.exception.ValidateException;

public interface ReqValidateManager<T> {
    void doExecute(T arg) throws ValidateException;
}
