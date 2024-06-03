package com.example.client_register_api.controller.swagger;

import com.example.client_register_api.entity.Client;
import com.example.client_register_api.request.ClientRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Client Controller", description = "Manage Client Information")
public interface ClientSwagger {

    @Operation(summary = "Save Client")
    @ApiResponses(value = {
            @ApiResponse(description = "Client Registered",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Bad Request",
                    responseCode = "400",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Internal Server Error",
                    responseCode = "500",
                    content = @Content(mediaType = "application/json"))})
    ResponseEntity<Void> saveClientController(@RequestBody ClientRequestDto clientRequestDto);

    @Operation(summary = "Find All Clients")
    @ApiResponses(value = {
            @ApiResponse(description = "Client's List",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Client.class)))),
            @ApiResponse(description = "Bad Request",
                    responseCode = "400",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Internal Server Error",
                    responseCode = "500",
                    content = @Content(mediaType = "application/json"))})
    ResponseEntity<List<Client>> findAll();

    @Operation(summary = "Find Client By Id")
    @ApiResponses(value = {
            @ApiResponse(description = "Client Found",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))),
            @ApiResponse(description = "Bad Request",
                    responseCode = "400",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Internal Server Error",
                    responseCode = "500",
                    content = @Content(mediaType = "application/json"))})
    ResponseEntity<Client> findById(@PathVariable long id);

    @Operation(summary = "Update Client By Id")
    @ApiResponses(value = {
            @ApiResponse(description = "Client Updated",
                    responseCode = "204",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Bad Request",
                    responseCode = "400",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Internal Server Error",
                    responseCode = "500",
                    content = @Content(mediaType = "application/json"))})
    ResponseEntity<Void> updateById(@PathVariable long id, @RequestBody ClientRequestDto clientRequestDto);

    @Operation(summary = "Delete Client By Id")
    @ApiResponses(value = {
            @ApiResponse(description = "Client Found",
                    responseCode = "204",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(description = "Bad Request",
                    responseCode = "400",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "Internal Server Error",
                    responseCode = "500",
                    content = @Content(mediaType = "application/json"))})
    ResponseEntity<Client> deleteById(@PathVariable long id);
}
