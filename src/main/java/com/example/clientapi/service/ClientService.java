package com.example.clientapi.service;

import com.example.clientapi.entity.Client;
import com.example.clientapi.exception.ApiException;
import com.example.clientapi.factory.ClientFactory;
import com.example.clientapi.repository.ClientRepository;
import com.example.clientapi.request.ClientRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientFactory clientFactory;
    private final ClientRepository clientRepository;

    public Client saveClient(ClientRequestDto clientRequestDto){
        Client client = clientFactory.buildClient(clientRequestDto);
        return clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(long id){
        return clientRepository.findById(id).orElseThrow(() -> new ApiException("Client not found", NOT_FOUND));
    }

    public void updateById(long id, ClientRequestDto clientRequestDto){
        Client client = findById(id);
        client.setFullName(clientRequestDto.getFullName());
        client.setSocialName(clientRequestDto.getSocialName());
        client.setBirthDate(LocalDate.parse(clientRequestDto.getBirthDate()));
        client.setGender(clientRequestDto.getGender());
        client.setCpf(clientRequestDto.getCpf());
        client.setRg(clientRequestDto.getRg());
        client.setEmail(clientRequestDto.getEmail());
        clientRepository.save(client);
    }

    public void deleteById(long id){
        Client client = findById(id);
        clientRepository.delete(client);
    }
}
