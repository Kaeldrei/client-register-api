package com.example.clientapi.factory;

import com.example.clientapi.entity.Client;
import com.example.clientapi.request.ClientRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.clientapi.utils.DateUtils.parseToLocalDate;

@Component
@RequiredArgsConstructor
public class ClientFactory {

    public Client buildClient(ClientRequestDto clientRequestDto){
        return Client.builder()
                .id(1L)
                .fullName("Ayrton Senna")
                .socialName("Beco")
                .birthDate(parseToLocalDate(clientRequestDto.getBirthDate()))
                .gender("Masculino")
                .cpf("019.619.630-27")
                .rg("30.040.591-1")
                .email("jhodoe@gmail.com")
                .build();
    }
}
