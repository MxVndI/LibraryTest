package ru.dynamica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dynamica.model.author.Author;
import ru.dynamica.model.author.AuthorId;

@Repository
public interface AuthorRepository extends JpaRepository<Author, AuthorId> {
}
