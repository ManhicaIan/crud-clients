package com.manhica.crud_clients.services;

import com.manhica.crud_clients.dto.ClientDTO;
import com.manhica.crud_clients.entities.Client;
import com.manhica.crud_clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> getAll(Pageable pageable){
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(client -> new ClientDTO(client));
    }

}
