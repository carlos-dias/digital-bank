package br.com.carlosdias.digitalbank.resources;

import br.com.carlosdias.digitalbank.mapper.TransactionMapper;
import br.com.carlosdias.digitalbank.requests.TransferRequest;
import br.com.carlosdias.digitalbank.responses.TransactionResponse;
import br.com.carlosdias.digitalbank.services.TransactionService;
import br.com.carlosdias.digitalbank.services.TransferService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
@Slf4j
public class TransactionResource {
    private final TransactionService transactionService;
    private final TransferService transferService;
    private final TransactionMapper transactionMapper;

    @PostMapping("/transfer")
    public void transfer(@RequestBody @Valid TransferRequest transferRequest) {
        log.info("m=transfer, transferRequest={}", transferRequest);
        transferService.transfer(transactionMapper.toCommand(transferRequest));
    }

    @GetMapping("/account/{accountId}")
    public Page<TransactionResponse> getTransactions(@PathVariable("accountId") Long accountId, Pageable pageable) {
        log.info("m=getTransactions, accountId={}, pageable={}", accountId, pageable);
        return transactionService.getTransactions(accountId, pageable).map(transactionMapper::toResponse);
    }
}
