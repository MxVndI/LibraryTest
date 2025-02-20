package ru.dynamica.model.book.bookUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;
import ru.dynamica.repository.AuthorRepository;


public class AuthorUpdateHandler implements BookUpdateHandler {
    private BookUpdateHandler next;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void setNext(BookUpdateHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Book book, BookDto bookDto) {
        if (bookDto.getAuthor() != null) {
            book.setAuthor(bookDto.getAuthor());
            authorRepository.save(bookDto.getAuthor());
        }
        if (next != null) {
            next.handle(book, bookDto);
        }
    }
}