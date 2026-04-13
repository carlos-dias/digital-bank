package br.com.carlosdias.digitalbank.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransferRequest(
        @Schema(description = "Conta origem para a transferência", example = "1")
        @NotNull(message = "Source account id is required")
        Long fromAccountId,

        @Schema(description = "Conta destino para a transferência", example = "2")
        @NotNull(message = "Destination account id is required")
        Long toAccountId,

        @Schema(description = "Valor utilizado para a transferência", example = "1000")
        @NotNull(message = "Amount to transfer is required")
        @Min(value = 1, message = "Amount must be greater than 0")
        Long amount
) {
}