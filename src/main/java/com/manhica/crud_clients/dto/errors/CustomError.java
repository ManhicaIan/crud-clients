package com.manhica.crud_clients.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class CustomError {

    private Instant timestamp;
    private int status;
    private String error;
    private String path;


}
