package ru.dynamica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dynamica.model.book.BookDto;
import ru.dynamica.service.BookService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public String findAllBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        model.addAttribute("bookDto", new BookDto());
        return "book/book-list";
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "book/book-form";
    }

    @PatchMapping("/{id}")
    public String updateBook(@PathVariable("id") Integer id, BookDto bookDto) {
        bookService.updateBook(id, bookDto);
        return "redirect:book/book-list";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        BookDto bookDto = bookService.findById(id);
        model.addAttribute("bookDto", bookDto);
        return "book/book-edit";
    }

    @PostMapping("/new")
    public String addBook(@ModelAttribute BookDto bookDto) {
        bookService.create(bookDto);
        return "redirect:/books";
    }
}
