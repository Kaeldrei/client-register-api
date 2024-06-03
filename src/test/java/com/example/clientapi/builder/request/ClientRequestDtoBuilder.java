package com.example.clientapi.builder.request;

import com.example.clientapi.request.ClientRequestDto;

import java.time.LocalDate;

public class ClientRequestDtoBuilder {

    private ClientRequestDto clientRequestDto;

    public static ClientRequestDtoBuilder builderClientRequestDtoDefault(){
        ClientRequestDtoBuilder builder = new ClientRequestDtoBuilder();

        builder.clientRequestDto = ClientRequestDto.builder()
                .fullName("Ayrton Senna")
                .socialName("Beco")
                .birthDate("1960-03-21")
                .cpf("019.619.630-27")
                .rg("30.040.591-1")
                .gender("Masculino")
                .email("jhodoe@gmail.com")
                .build();
        return builder;
    }

    public ClientRequestDto build(){
        return clientRequestDto;
    }
}
