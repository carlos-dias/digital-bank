package br.com.carlosdias.digitalbank.exceptions;

import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.INSUFFICIENT_BALANCE_OR_ACCOUNT_NOT_FOUND_ERROR_CODE;

public class InsufficientBalanceOrAccountNotFoundException extends AbstractDigitalBankException {
    public InsufficientBalanceOrAccountNotFoundException() {
        super(INSUFFICIENT_BALANCE_OR_ACCOUNT_NOT_FOUND_ERROR_CODE, "Insufficient balance or account not found");
    }
}
