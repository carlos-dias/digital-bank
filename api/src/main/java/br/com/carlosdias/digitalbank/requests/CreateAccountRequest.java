package br.com.carlosdias.digitalbank.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateAccountRequest(
        @Schema(description = "Saldo inicial em centavos", example = "1000")
        @Min(value = 0, message = "Balance cannot be negative")
        BigDecimal balance,

        @Schema(description = "Nome do titular", example = "Carlos")
        @NotBlank(message = "Name is required")
        @Size(max = 255, message = "Name must have at most 255 characters")
        String name
) {
}
