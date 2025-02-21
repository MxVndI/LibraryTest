package ru.dynamica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dynamica.model.bookloan.BookLoanDto;
import ru.dynamica.service.BookLoanService;

import java.util.List;

@RestController
@RequestMapping("/books/loans")
@RequiredArgsConstructor
public class BookLoanController {
    private final BookLoanService bookLoanService;

    @PostMapping
    public BookLoanDto loanBook(@RequestBody BookLoanDto bookLoanDto) {
        return bookLoanService.loanBook(bookLoanDto);
    }

    @GetMapping
    public List<BookLoanDto> getAllLoans() {
        return bookLoanService.getAllLoans();
    }
}