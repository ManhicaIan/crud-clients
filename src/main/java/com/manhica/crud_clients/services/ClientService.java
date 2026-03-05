package com.manhica.crud_clients.services;

import com.manhica.crud_clients.dto.ClientDTO;
import com.manhica.crud_clients.entities.Client;
import com.manhica.crud_clients.repositories.ClientRepository;
import com.manhica.crud_clients.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional(readOnly = true)
    public ClientDTO getById(Long id){
        Client client = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyDtoToEntity(client, dto);
        repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        try {
            Client client = repository.getReferenceById(id);
            copyDtoToEntity(client, dto);
            client = repository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Client not found");
        }
    }


    private void copyDtoToEntity(Client client, ClientDTO dto){
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setChildren(dto.getChildren());
        client.setBirthDate(dto.getBirthDate());
    }
}
