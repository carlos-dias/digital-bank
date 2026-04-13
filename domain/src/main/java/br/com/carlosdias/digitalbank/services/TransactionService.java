package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.entities.TransactionEntity;
import br.com.carlosdias.digitalbank.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Page<TransactionEntity> getTransactions(Long accountId, Pageable pageable) {
        return transactionRepository.findByAccountIdOrderByCreatedAtDesc(accountId, pageable);
    }
}
