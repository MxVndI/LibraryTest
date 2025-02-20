package ru.dynamica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dynamica.model.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
