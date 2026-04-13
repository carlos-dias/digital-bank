package br.com.carlosdias.digitalbank.resources;

import br.com.carlosdias.digitalbank.mapper.TransactionMapper;
import br.com.carlosdias.digitalbank.requests.TransferRequest;
import br.com.carlosdias.digitalbank.services.TransferService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
@Slf4j
public class TransactionResource {
    private final TransferService transferService;
    private final TransactionMapper transactionMapper;

    @PostMapping("/transfer")
    public void transfer(@RequestBody @Valid TransferRequest transferRequest) {
        log.info("m=transfer, transferRequest={}", transferRequest);
        transferService.transfer(transactionMapper.toCommand(transferRequest));
    }
}
