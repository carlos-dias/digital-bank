package br.com.carlosdias.digitalbank.commands;

public record TransferCommand(
        Long fromAccountId,
        Long toAccountId,
        Long amount
) {}