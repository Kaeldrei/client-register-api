package com.example.clientapi.controller;

import com.example.clientapi.entity.Client;
import com.example.clientapi.request.ClientRequestDto;
import com.example.clientapi.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static com.example.clientapi.builder.ClientBuilder.builderClientDefault;
import static com.example.clientapi.builder.request.ClientRequestDtoBuilder.builderClientRequestDtoDefault;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private ClientService clientService;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("Should Register Client")
    void shouldRegisterClient() throws Exception{
        //Data
        ClientRequestDto clientRequestDto = builderClientRequestDtoDefault().build();
        //Action
        mockMvc.perform(post("/client/register")
                    .contentType(APPLICATION_JSON)
                    .content(writeValueAsString(clientRequestDto)))
        //Result
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should Find All Clients")
    void shouldFindAllClients() throws Exception{
        //Data
        List<Client> clientList = builderClientDefault().tolist();

        when(clientService.findAll()).thenReturn(clientList);
        //Action
        mockMvc.perform(get("/client")
                .contentType(APPLICATION_JSON))
                //Result
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should Find Client By ID")
    void shouldFindClientById() throws Exception {
        //Data
        Client client = builderClientDefault().build();

        when(clientService.findById(1)).thenReturn(client);
        //Action
        mockMvc.perform(get("/client/1")
                .contentType(APPLICATION_JSON))
                //Result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(client.getId()))
                .andExpect(jsonPath("$.fullName").value(client.getFullName()))
                .andExpect(jsonPath("$.socialName").value(client.getSocialName()))
                .andExpect(jsonPath("$.birthDate").value(client.getBirthDate().toString()))
                .andExpect(jsonPath("$.gender").value(client.getGender()))
                .andExpect(jsonPath("$.cpf").value(client.getCpf()))
                .andExpect(jsonPath("$.rg").value(client.getRg()))
                .andExpect(jsonPath("$.email").value(client.getEmail()));
    }

    @Test
    @DisplayName("Should Update Client By ID")
    void shouldUpdateClientById() throws Exception{
        //Data
        long id = 1L;
        ClientRequestDto clientRequestDto = builderClientRequestDtoDefault().build();

        doNothing().when(clientService).updateById(id, clientRequestDto);
        //Action
        mockMvc.perform(put("/client/{id}", id)
                .contentType(APPLICATION_JSON)
                .content(writeValueAsString(clientRequestDto)))
                //Result
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Should Delete Client By ID")
    void shouldDeleteClientById() throws Exception{
        //Data
        long id = 1L;

        doNothing().when(clientService).deleteById(id);
        //Action
        mockMvc.perform(delete("/client/{id}", id)
                .contentType(APPLICATION_JSON))
                //Result
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    private String writeValueAsString(Object value) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(value);
    }
}
