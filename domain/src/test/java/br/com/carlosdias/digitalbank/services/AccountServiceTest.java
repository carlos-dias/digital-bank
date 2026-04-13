package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.entities.AccountEntity;
import br.com.carlosdias.digitalbank.exceptions.AccountBalanceInvalidValueException;
import br.com.carlosdias.digitalbank.exceptions.AccountNameCannotBeEmptyException;
import br.com.carlosdias.digitalbank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;
    @Mock
    private AccountRepository accountRepository;

    @Test
    void should_createAccount_successfully() {
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountEntity.getName()).thenReturn("Test");
        when(accountEntity.getBalance()).thenReturn(1L);

        accountService.createAccount(accountEntity);

        verify(accountRepository).save(accountEntity);
    }

    @Test
    void should_throw_accountNameCannotBeEmptyException_with_name_null() {
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountEntity.getName()).thenReturn(null);

        assertThatThrownBy(() -> accountService.createAccount(accountEntity))
                .isInstanceOf(AccountNameCannotBeEmptyException.class);
    }

    @Test
    void should_throw_accountNameCannotBeEmptyException_with_name_empty() {
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountEntity.getName()).thenReturn("");

        assertThatThrownBy(() -> accountService.createAccount(accountEntity))
                .isInstanceOf(AccountNameCannotBeEmptyException.class);
    }

    @Test
    void should_throw_accountBalanceInvalidValueException_with_balance_null() {
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountEntity.getName()).thenReturn("Test");
        when(accountEntity.getBalance()).thenReturn(null);

        assertThatThrownBy(() -> accountService.createAccount(accountEntity))
                .isInstanceOf(AccountBalanceInvalidValueException.class);
    }

    @Test
    void should_throw_accountBalanceInvalidValueException_with_balance_negative() {
        AccountEntity accountEntity = mock(AccountEntity.class);

        when(accountEntity.getName()).thenReturn("Test");
        when(accountEntity.getBalance()).thenReturn(-1L);

        assertThatThrownBy(() -> accountService.createAccount(accountEntity))
                .isInstanceOf(AccountBalanceInvalidValueException.class);
    }
}
