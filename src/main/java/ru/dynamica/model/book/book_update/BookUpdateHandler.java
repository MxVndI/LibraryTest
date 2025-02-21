package ru.dynamica.model.book.book_update;

import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;

public interface BookUpdateHandler {
    void setNext(BookUpdateHandler next);
    void handle(Book book, BookDto bookDto);
}
