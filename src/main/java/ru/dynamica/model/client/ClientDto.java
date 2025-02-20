package ru.dynamica.model.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClientDto {
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
