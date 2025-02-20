package ru.dynamica.model.bookloan;

import lombok.Getter;
import lombok.Setter;
import ru.dynamica.model.book.Book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "book_loans")
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client_full_name", nullable = false)
    private String clientFullName;

    @Column(name = "client_birth_date", nullable = false)
    private LocalDate clientBirthDate;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;
}