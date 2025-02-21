package ru.dynamica.model.book.book_update;

import lombok.RequiredArgsConstructor;
import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;
import ru.dynamica.repository.AuthorRepository;

@RequiredArgsConstructor
public class AuthorUpdateHandler implements BookUpdateHandler {
    private BookUpdateHandler next;
    private final AuthorRepository authorRepository;

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