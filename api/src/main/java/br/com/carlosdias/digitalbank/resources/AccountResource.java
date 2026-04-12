package br.com.carlosdias.digitalbank.resources;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountResource {
    private final AccountService accountService;

    @GetMapping
    public List<AccountEntity> findAll() {
        return accountService.findAll();
    }
}
