package br.com.carlosdias.digitalbank.producers.events;

import java.util.UUID;

public record TransferEvent(
        UUID referenceId,
        Long fromAccountId,
        Long toAccountId,
        Long amount
) {}