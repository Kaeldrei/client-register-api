package com.example.clientapi.builder;

import com.example.clientapi.entity.Client;

import java.time.LocalDate;
import java.util.List;

public class ClientBuilder {

    private Client client;

    public static ClientBuilder builderClientDefault(){
        ClientBuilder builder = new ClientBuilder();

        builder.client = Client.builder()
                .id(1L)
                .fullName("Ayrton Senna")
                .socialName("Beco")
                .birthDate(LocalDate.of(1960, 3, 21))
                .gender("Masculino")
                .cpf("019.619.630-27")
                .rg("30.040.591-1")
                .email("jhodoe@gmail.com")
                .build();
        return builder;
    }

    public static ClientBuilder builderClientWithoutIdDefault(){
        ClientBuilder builder = new ClientBuilder();

        builder.client = Client.builder()
                .fullName("Ayrton Senna")
                .socialName("Beco")
                .birthDate(LocalDate.of(1960, 3, 21))
                .gender("Masculino")
                .cpf("019.619.630-27")
                .rg("30.040.591-1")
                .email("jhodoe@gmail.com")
                .build();
        return builder;
    }

    public Client build(){
        return client;
    }

    public List<Client> tolist(){
        return List.of(client);
    }
}
