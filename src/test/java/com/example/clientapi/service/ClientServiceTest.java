package com.example.clientapi.service;

import com.example.clientapi.entity.Client;
import com.example.clientapi.factory.ClientFactory;
import com.example.clientapi.repository.ClientRepository;
import com.example.clientapi.request.ClientRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.example.clientapi.builder.ClientBuilder.builderClientDefault;
import static com.example.clientapi.builder.request.ClientRequestDtoBuilder.builderClientRequestDtoDefault;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientFactory clientFactory;

    @Mock
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Should Save Client")
    void shouldSaveClient(){
        //Data
        Client client = builderClientDefault().build();
        ClientRequestDto clientRequestDto = builderClientRequestDtoDefault().build();

        when(clientFactory.buildClient(clientRequestDto)).thenReturn(client);

        //Action
        clientService.saveClient(clientRequestDto);

        //Result
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    @DisplayName("Should Find All Clients")
    void shouldFindAllClients(){
        //Data
        List<Client> clientList = builderClientDefault().tolist();

        when(clientRepository.findAll()).thenReturn(clientList);

        //Action
        List<Client> result = clientService.findAll();

        //Result
        verify(clientRepository, times(1)).findAll();
        assertThat(result).isEqualTo(clientList);
    }

    @Test
    @DisplayName("Should Find Client Given Client ID")
    void shouldFindClientGivenClientId(){
        //Data
        Client client = builderClientDefault().build();

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        //Action
        Client result = clientService.findById(1L);
        //Result
        verify(clientRepository, times(1)).findById(1L);
        assertThat(result).isEqualTo(client);
    }

    @Test
    @DisplayName("Should Update Client Given Client ID")
    void shouldUpdateClientGivenClientId(){
        //Data
        Client client = builderClientDefault().build();
        ClientRequestDto clientRequestDto = builderClientRequestDtoDefault().build();

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        //Action
        clientService.updateById(1L, clientRequestDto);
        //Result
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    @DisplayName("Should Delete Client Given Client ID")
    void shouldDeleteClientGivenClientId(){
        //Data
        Client client = builderClientDefault().build();

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        //Action
        clientService.deleteById(1L);
        //Result
        verify(clientRepository, times(1)).delete(client);
    }
}
