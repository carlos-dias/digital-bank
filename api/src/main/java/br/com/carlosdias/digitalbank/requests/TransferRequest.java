package br.com.carlosdias.digitalbank.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransferRequest(

        @NotNull(message = "Source account id is required")
        Long fromAccountId,

        @NotNull(message = "Destination account id is required")
        Long toAccountId,

        @NotNull(message = "Amount to transfer is required")
        @Min(value = 1, message = "Amount must be greater than 0")
        Long amount
) {
}