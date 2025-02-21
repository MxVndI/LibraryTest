package ru.dynamica.model.bookloan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookLoanDto {
    private Integer clientId;
    private Integer bookId;
}