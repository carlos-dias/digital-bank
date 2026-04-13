package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.commands.TransferCommand;
import br.com.carlosdias.digitalbank.exceptions.AccountNotFoundException;
import br.com.carlosdias.digitalbank.exceptions.InsufficientBalanceOrAccountNotFoundException;
import br.com.carlosdias.digitalbank.exceptions.TransferToSameAccountException;
import br.com.carlosdias.digitalbank.producers.TransferProducer;
import br.com.carlosdias.digitalbank.repositories.AccountRepository;
import br.com.carlosdias.digitalbank.repositories.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {
    @InjectMocks
    private TransferService transferService;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private TransferProducer transferProducer;

    @Test
    void should_transfer_successfully() {
        Long fromAccountId = 10L;
        Long toAccountId = 20L;
        Long amount = 1000L;

        TransferCommand command = new TransferCommand(fromAccountId, toAccountId, amount);

        when(accountRepository.debit(command.fromAccountId(), command.amount())).thenReturn(1);
        when(accountRepository.credit(command.toAccountId(), command.amount())).thenReturn(1);

        transferService.transfer(command);

        verify(accountRepository).debit(command.fromAccountId(), command.amount());
        verify(accountRepository).credit(command.toAccountId(), command.amount());
        verify(transactionRepository, times(2)).save(any());
        verify(transferProducer).send(any());
    }

    @Test
    void should_throw_transferToSameAccountException() {
        Long fromAccountId = 10L;
        Long toAccountId = 10L;
        Long amount = 1000L;

        TransferCommand command = new TransferCommand(fromAccountId, toAccountId, amount);

        assertThatThrownBy(() -> transferService.transfer(command))
                .isInstanceOf(TransferToSameAccountException.class);
    }

    @Test
    void should_throw_insufficientBalanceOrAccountNotFoundException() {
        Long fromAccountId = 10L;
        Long toAccountId = 20L;
        Long amount = 1000L;

        TransferCommand command = new TransferCommand(fromAccountId, toAccountId, amount);

        when(accountRepository.debit(command.fromAccountId(), command.amount())).thenReturn(0);

        assertThatThrownBy(() -> transferService.transfer(command))
                .isInstanceOf(InsufficientBalanceOrAccountNotFoundException.class);
    }

    @Test
    void should_throw_accountNotFoundException() {
        Long fromAccountId = 10L;
        Long toAccountId = 20L;
        Long amount = 1000L;

        TransferCommand command = new TransferCommand(fromAccountId, toAccountId, amount);

        when(accountRepository.debit(command.fromAccountId(), command.amount())).thenReturn(1);
        when(accountRepository.credit(command.toAccountId(), command.amount())).thenReturn(0);

        assertThatThrownBy(() -> transferService.transfer(command))
                .isInstanceOf(AccountNotFoundException.class);
    }
}
