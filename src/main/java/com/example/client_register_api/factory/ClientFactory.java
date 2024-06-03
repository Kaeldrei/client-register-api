package com.example.client_register_api.factory;

import com.example.client_register_api.entity.Client;
import com.example.client_register_api.request.ClientRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.client_register_api.utils.DateUtils.parseToLocalDate;

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
