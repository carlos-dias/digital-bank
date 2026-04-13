package br.com.carlosdias.digitalbank.mapper;

import br.com.carlosdias.digitalbank.commands.TransferCommand;
import br.com.carlosdias.digitalbank.requests.TransferRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransferCommand toCommand(TransferRequest request);
}