package com.manhica.crud_clients.dto.errors.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {
    private String field;
    private String message;
}
