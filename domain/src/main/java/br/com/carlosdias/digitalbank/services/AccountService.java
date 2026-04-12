package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }
}
