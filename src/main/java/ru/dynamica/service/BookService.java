package ru.dynamica.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamica.model.author.Author;
import ru.dynamica.model.author.AuthorId;
import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;
import ru.dynamica.model.book.BookMapper;
import ru.dynamica.model.book.bookUpdate.AuthorUpdateHandler;
import ru.dynamica.model.book.bookUpdate.BookUpdateHandler;
import ru.dynamica.model.book.bookUpdate.ISBNUpdateHandler;
import ru.dynamica.model.book.bookUpdate.TitleUpdateHandler;
import ru.dynamica.repository.AuthorRepository;
import ru.dynamica.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookDto create(BookDto bookDto) {
        validateBookDto(bookDto);
        AuthorId authorId = new AuthorId();
        authorId.setName(bookDto.getAuthor().getId().getName());
        authorId.setLastName(bookDto.getAuthor().getId().getLastName());
        Optional<Author> author = authorRepository.findById(authorId);
        Author authorEntity = author.orElseGet(() -> {
            Author newAuthor = new Author();
            newAuthor.setId(authorId);
            return authorRepository.save(newAuthor);
        });
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setAuthor(authorEntity);
        bookRepository.save(book);
        return BookMapper.toBookDto(book);
    }

    public BookDto findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        checkBookExist(book);
        return BookMapper.toBookDto(book.get());
    }

    public BookDto updateBook(Integer id, BookDto bookDto) {
        BookUpdateHandler handlerChain = createUpdateHandlerChain();
        Optional<Book> bookOptional = bookRepository.findById(id);
        checkBookExist(bookOptional);
        Book book = bookOptional.get();
        handlerChain.handle(book, bookDto);
        bookRepository.save(book);
        return BookMapper.toBookDto(book);
    }

    public List<BookDto> findAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            bookDtos.add(BookMapper.toBookDto(book));
        }
        return bookDtos;
    }

    private void checkBookExist(Optional<Book> book) {
        if (!book.isPresent()) {
            throw new RuntimeException("temp");
        }
    }

    private void validateBookDto(BookDto bookDto) {
        if (bookDto.getTitle() == null || bookDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
        if (bookDto.getIsbn() == null || bookDto.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("ISBN не может быть пустым");
        }
        if (bookDto.getAuthor() == null) {
            throw new IllegalArgumentException("Автор должен быть указан");
        }
    }

    private BookUpdateHandler createUpdateHandlerChain() {
        BookUpdateHandler titleHandler = new TitleUpdateHandler();
        BookUpdateHandler isbnHandler = new ISBNUpdateHandler();
        BookUpdateHandler authorHandler = new AuthorUpdateHandler();
        titleHandler.setNext(isbnHandler);
        isbnHandler.setNext(authorHandler);
        return titleHandler;
    }
}
