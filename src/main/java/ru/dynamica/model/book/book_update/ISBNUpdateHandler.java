package ru.dynamica.model.book.book_update;

import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;

public class ISBNUpdateHandler implements BookUpdateHandler {
    private BookUpdateHandler next;

    @Override
    public void setNext(BookUpdateHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Book book, BookDto bookDto) {
        if (bookDto.getIsbn() != null) {
            book.setIsbn(bookDto.getIsbn());
        }
        if (next != null) {
            next.handle(book, bookDto);
        }
    }
}