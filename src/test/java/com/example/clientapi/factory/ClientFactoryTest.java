package com.example.clientapi.factory;

import com.example.clientapi.entity.Client;
import com.example.clientapi.request.ClientRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.clientapi.builder.ClientBuilder.builderClientDefault;
import static com.example.clientapi.builder.request.ClientRequestDtoBuilder.builderClientRequestDtoDefault;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ClientFactoryTest {

    @InjectMocks
    private ClientFactory clientFactory;

    @Test
    @DisplayName("Should build Client Given ClientRequestDto")
    void shouldBuildClientGivenClientRequestDto(){
        //Data
        ClientRequestDto clientRequestDto = builderClientRequestDtoDefault().build();
        Client expected = builderClientDefault().build();

        //Action
        Client result = clientFactory.buildClient(clientRequestDto);

        //Result
        assertThat(result).isEqualTo(expected);
    }
}
