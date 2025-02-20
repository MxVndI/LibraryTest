package ru.dynamica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dynamica.model.bookloan.BookLoan;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {
}