package ru.dynamica.model.book;

public class BookMapper {
    public static BookDto toBookDto(Book book) {
        return new BookDto(
                book.getTitle(),
                book.getIsbn(),
                book.getAuthor()
        );
    }
}
