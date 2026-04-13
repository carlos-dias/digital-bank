package br.com.carlosdias.digitalbank.mapper;

import br.com.carlosdias.digitalbank.commands.TransferCommand;
import br.com.carlosdias.digitalbank.entities.TransactionEntity;
import br.com.carlosdias.digitalbank.requests.TransferRequest;
import br.com.carlosdias.digitalbank.responses.TransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransferCommand toCommand(TransferRequest request);

    TransactionResponse toResponse(TransactionEntity entity);
}