package com.example.client_register_api.controller;

import com.example.client_register_api.controller.swagger.ClientSwagger;
import com.example.client_register_api.entity.Client;
import com.example.client_register_api.request.ClientRequestDto;
import com.example.client_register_api.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController implements ClientSwagger {

    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Void> saveClientController(ClientRequestDto clientRequestDto){
        clientService.saveClient(clientRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> clientList = clientService.findAll();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Client> findById(long id){
        Client client = clientService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateById(long id, ClientRequestDto clientRequestDto){
        clientService.updateById(id, clientRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteById(long id){
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
