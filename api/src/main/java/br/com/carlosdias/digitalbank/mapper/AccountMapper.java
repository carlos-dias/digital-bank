package br.com.carlosdias.digitalbank.mapper;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.requests.CreateAccountRequest;
import br.com.carlosdias.digitalbank.responses.AccountResponse;
import br.com.carlosdias.digitalbank.utils.DecimalUtils;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DecimalUtils.class)
public interface AccountMapper {
    AccountEntity toEntity(CreateAccountRequest request);

    AccountResponse toResponse(AccountEntity entity);
}
