package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.exceptions.AccountBalanceInvalidValueException;
import br.com.carlosdias.digitalbank.exceptions.AccountNameCannotBeEmptyException;
import br.com.carlosdias.digitalbank.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountEntity createAccount(AccountEntity accountEntity) {
        log.info("m=createAccount, accountEntity={}", accountEntity);

        validateCreateAccount(accountEntity);

        return accountRepository.save(accountEntity);
    }

    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    private void validateCreateAccount(AccountEntity accountEntity) {
        if (ObjectUtils.isEmpty(accountEntity.getName())) {
            throw new AccountNameCannotBeEmptyException();
        }
        if (accountEntity.getBalance() == null || accountEntity.getBalance() < 0) {
            throw new AccountBalanceInvalidValueException();
        }
    }
}
