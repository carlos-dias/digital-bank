package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.repositories.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionRepository transactionRepository;

    @Test
    void should_getTransactions_successfully() {
        Long accountId = 1L;
        Pageable pageable = Pageable.unpaged();

        transactionService.getTransactions(accountId, pageable);

        verify(transactionRepository).findByAccountIdOrderByCreatedAtDesc(accountId, pageable);
    }
}
