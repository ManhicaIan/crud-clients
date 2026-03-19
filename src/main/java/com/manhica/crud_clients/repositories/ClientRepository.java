package com.manhica.crud_clients.repositories;

import com.manhica.crud_clients.dto.ClientDTO;
import com.manhica.crud_clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM client_tb AS c WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<Client> searchByName(String name);
}
