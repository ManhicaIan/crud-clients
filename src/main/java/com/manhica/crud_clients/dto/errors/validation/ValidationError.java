package com.manhica.crud_clients.dto.errors.validation;

import com.manhica.crud_clients.dto.errors.CustomError;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, int status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addError(String field, String message){
        errors.add(new FieldMessage(field, message));
    }
}
