package br.com.carlosdias.digitalbank.services;

import br.com.carlosdias.digitalbank.commands.TransferCommand;
import br.com.carlosdias.digitalbank.entities.TransactionEntity;
import br.com.carlosdias.digitalbank.enums.TransactionType;
import br.com.carlosdias.digitalbank.exceptions.AccountNotFoundException;
import br.com.carlosdias.digitalbank.exceptions.InsufficientBalanceOrAccountNotFoundException;
import br.com.carlosdias.digitalbank.exceptions.TransferToSameAccountException;
import br.com.carlosdias.digitalbank.producers.TransferProducer;
import br.com.carlosdias.digitalbank.producers.events.TransferEvent;
import br.com.carlosdias.digitalbank.repositories.AccountRepository;
import br.com.carlosdias.digitalbank.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class TransferService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransferProducer transferProducer;

    @Transactional
    public void transfer(TransferCommand command) {
        try {
            if (command.fromAccountId().equals(command.toAccountId())) {
                throw new TransferToSameAccountException();
            }

            int update = accountRepository.debit(command.fromAccountId(), command.amount());

            if (update == 0) {
                throw new InsufficientBalanceOrAccountNotFoundException();
            }

            update = accountRepository.credit(command.toAccountId(), command.amount());

            if (update == 0) {
                throw new AccountNotFoundException();
            }

            UUID referenceId = UUID.randomUUID();

            TransactionEntity debit = createTransaction(command.fromAccountId(), command.amount(), TransactionType.DEBIT, referenceId);

            TransactionEntity credit = createTransaction(command.toAccountId(), command.amount(), TransactionType.CREDIT, referenceId);

            transactionRepository.save(debit);
            transactionRepository.save(credit);

            transferProducer.send(new TransferEvent(referenceId, command.fromAccountId(), command.toAccountId(), command.amount()));

            log.info("m=transfer, result=true");
        } catch (Exception e) {
            log.warn("m=transfer, result=false, command={}, message={}", command, e.getMessage());
            throw e;
        }
    }

    private TransactionEntity createTransaction(Long accountId, Long amount, TransactionType transactionType, UUID referenceId) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(accountId);
        transactionEntity.setType(transactionType);
        transactionEntity.setAmount(amount);
        transactionEntity.setReferenceId(referenceId);
        return transactionEntity;
    }
}
