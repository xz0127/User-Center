package com.example.userCenter.component.validation;

import com.example.userCenter.component.exception.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReqValidateManagerImpl<T> implements ReqValidateManager<T> {

    @Autowired
    private List<FormValidator> validators;

    @Override
    public void doExecute(T arg) throws ValidateException {
        for(FormValidator formValidator: validators) {
            if (formValidator.canAccept(arg)) {
                formValidator.validate(arg);
            }
        }
    }
}
