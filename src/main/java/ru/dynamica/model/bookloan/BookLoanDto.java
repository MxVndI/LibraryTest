package ru.dynamica.model.bookloan;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookLoanDto {
    private String clientFullName;
    private LocalDate clientBirthDate;
    private Integer bookId; // ID книги, которую нужно одолжить
}