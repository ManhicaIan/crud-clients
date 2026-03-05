package com.manhica.crud_clients.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    private String name;

    private String cpf;

    private double income;

    private LocalDate birthDate;

    private int children;

}
