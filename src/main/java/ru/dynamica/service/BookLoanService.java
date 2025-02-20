package ru.dynamica.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamica.model.bookloan.BookLoan;
import ru.dynamica.model.book.Book;
import ru.dynamica.repository.BookLoanRepository;
import ru.dynamica.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanService {
    private final BookLoanRepository bookLoanRepository;
    private final BookRepository bookRepository; // Добавляем репозиторий для работы с книгами

    public void loanBook(String clientFullName, LocalDate clientBirthDate, Integer bookId) {
        // Находим книгу по ID
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Создаем запись о выдаче книги
        BookLoan loan = new BookLoan();
        loan.setClientFullName(clientFullName);
        loan.setClientBirthDate(clientBirthDate);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());

        // Сохраняем запись в базе данных
        bookLoanRepository.save(loan);
    }

    public List<BookLoan> getAllLoans() {
        return bookLoanRepository.findAll();
    }
}