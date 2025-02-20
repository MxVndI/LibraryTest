package ru.dynamica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dynamica.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
