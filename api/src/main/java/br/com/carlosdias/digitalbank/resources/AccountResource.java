package br.com.carlosdias.digitalbank.resources;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.mapper.AccountMapper;
import br.com.carlosdias.digitalbank.requests.CreateAccountRequest;
import br.com.carlosdias.digitalbank.responses.AccountResponse;
import br.com.carlosdias.digitalbank.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@Slf4j
public class AccountResource {
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Operation(summary = "Criar conta")
    @PostMapping
    public AccountResponse createAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        log.info("m=createAccount");

        AccountEntity accountEntity = accountMapper.toEntity(createAccountRequest);
        return accountMapper.toResponse(accountService.createAccount(accountEntity));
    }

}
