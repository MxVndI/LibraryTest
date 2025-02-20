package ru.dynamica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dynamica.model.book.BookDto;
import ru.dynamica.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @PatchMapping("/{id}")
    public BookDto updateBook(@PathVariable("id") Integer id, BookDto bookDto) {
        return bookService.updateBook(id, bookDto);
    }

    @PostMapping()
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }
}
