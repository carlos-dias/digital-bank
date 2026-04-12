package br.com.carlosdias.digitalbank.resources;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.mapper.AccountMapper;
import br.com.carlosdias.digitalbank.requests.CreateAccountRequest;
import br.com.carlosdias.digitalbank.responses.AccountResponse;
import br.com.carlosdias.digitalbank.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
@Slf4j
public class AccountResource {
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @PostMapping
    public AccountResponse createAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        log.info("m=createAccount");

        AccountEntity accountEntity = accountMapper.toEntity(createAccountRequest);
        return accountMapper.toResponse(accountService.createAccount(accountEntity));
    }

    @GetMapping
    public List<AccountEntity> findAll() {
        return accountService.findAll();
    }
}
