package ru.dynamica.model.book.bookUpdate;

import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;

public class TitleUpdateHandler implements BookUpdateHandler {
    private BookUpdateHandler next;

    @Override
    public void setNext(BookUpdateHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Book book, BookDto bookDto) {
        if (bookDto.getTitle() != null) {
            book.setTitle(bookDto.getTitle());
        }
        if (next != null) {
            next.handle(book, bookDto);
        }
    }
}