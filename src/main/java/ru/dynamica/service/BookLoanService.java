package ru.dynamica.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamica.exception.BookNotFoundException;
import ru.dynamica.exception.ClientNotFoundException;
import ru.dynamica.model.bookloan.BookLoan;
import ru.dynamica.model.book.Book;
import ru.dynamica.model.bookloan.BookLoanDto;
import ru.dynamica.model.bookloan.BookLoanMapper;
import ru.dynamica.model.client.Client;
import ru.dynamica.repository.BookLoanRepository;
import ru.dynamica.repository.BookRepository;
import ru.dynamica.repository.ClientRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanService {
    private final BookLoanRepository bookLoanRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;

    public BookLoanDto loanBook(BookLoanDto bookLoanDto) {
        Book book = bookRepository.findById(bookLoanDto.getBookId())
                .orElseThrow(() -> new BookNotFoundException("Книга не найдена"));
        BookLoan loan = new BookLoan();
        Client client = clientRepository.findById(bookLoanDto.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Клиент не найден"));
        loan.setClient(client);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        bookLoanRepository.save(loan);
        return BookLoanMapper.toDto(loan);
    }

    public List<BookLoan> getAllLoans() {
        return bookLoanRepository.findAll();
    }
}