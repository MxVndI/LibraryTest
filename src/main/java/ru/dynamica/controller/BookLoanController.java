package ru.dynamica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dynamica.model.bookloan.BookLoan;
import ru.dynamica.model.bookloan.BookLoanDto;
import ru.dynamica.service.BookLoanService;

import java.util.List;

@RestController
@RequestMapping("/books/loans")
public class BookLoanController {

    private final BookLoanService bookLoanService;

    @Autowired
    public BookLoanController(BookLoanService bookLoanService) {
        this.bookLoanService = bookLoanService;
    }

    @PostMapping
    public void loanBook(@RequestBody BookLoanDto bookLoanRequest) {
        bookLoanService.loanBook(
                bookLoanRequest.getClientFullName(),
                bookLoanRequest.getClientBirthDate(),
                bookLoanRequest.getBookId()
        );
    }

    @GetMapping
    public List<BookLoan> getAllLoans() {
        return bookLoanService.getAllLoans();
    }
}