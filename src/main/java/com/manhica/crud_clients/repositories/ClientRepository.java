package com.manhica.crud_clients.repositories;

import com.manhica.crud_clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
