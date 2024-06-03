package com.example.clientapi.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {

    @NotBlank(message = "Full Name Must Be Informed")
    @Schema(description = "Client's full name", example = "Ayrton Senna")
    private String fullName;

    @Schema(description = "Client's social name", example = "Beco")
    private String socialName;

    @NotBlank(message = "Birth Date Must Be Informed")
    @Schema(description = "Client's birth date", example = "1960-03-21")
    @Pattern(regexp = "\\d{4}- \\d{2}- \\d{2}", message = "Date must be informed in format yyyy-MM-dd")
    private String birthDate;

    @Schema(description = "Client's gender", example = "Masculino")
    private String gender;

    @NotBlank(message = "CPF Must Be Informed")
    @Schema(description = "Client's CPF", example = "019.619.630-27")
    private String cpf;

    @NotBlank(message = "RG Must Be Informed")
    @Schema(description = "Client's RG", example = "30.040.591-1")
    private String rg;

    @Email(message = "Must be a valid email")
    @Size(max = 255, message = "The email cannot exceed 255 characters")
    @Schema(description = "Client's email", example = "jhodoe@gmail.com")
    private String email;
}
