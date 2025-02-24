package ru.dynamica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dynamica.model.bookloan.BookLoan;
import ru.dynamica.model.bookloan.BookLoanDto;
import ru.dynamica.service.BookLoanService;

import java.util.List;

@Controller
@RequestMapping("/books/loans")
@RequiredArgsConstructor
public class BookLoanController {
    private final BookLoanService bookLoanService;

    @GetMapping("/new")
    public String showLoanForm(Model model) {
        model.addAttribute("bookLoanDto", new BookLoanDto());
        return "bookloan/bookloan-form";
    }

    @PostMapping
    public String loanBook(@ModelAttribute BookLoanDto bookLoanDto) {
        bookLoanService.loanBook(bookLoanDto);
        return "redirect:/books/loans";
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<BookLoan> getAllLoans() {
        return bookLoanService.getAllLoans();
    }
}
