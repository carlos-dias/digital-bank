package br.com.carlosdias.digitalbank.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponse(
        UUID referenceId,
        String type,
        Long amount,
        LocalDateTime createdAt
) {
}