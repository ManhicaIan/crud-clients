package com.manhica.crud_clients.controllers;

import com.manhica.crud_clients.dto.ClientDTO;
import com.manhica.crud_clients.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getAll(Pageable pageable){
        return ResponseEntity.ok(service.getAll(pageable));
    }
    @GetMapping("/search")
    public ResponseEntity<List<ClientDTO>> searchByName(@RequestParam String name){
        return ResponseEntity.ok(service.searchByName(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO clientDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(clientDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(clientDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
