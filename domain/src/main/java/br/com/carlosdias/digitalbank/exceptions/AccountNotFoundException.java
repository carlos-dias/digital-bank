package br.com.carlosdias.digitalbank.exceptions;

import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.ACCOUNT_NOT_FOUND_ERROR_CODE;

public class AccountNotFoundException extends AbstractDigitalBankException {
    public AccountNotFoundException() {
        super(ACCOUNT_NOT_FOUND_ERROR_CODE, "Account not found");
    }
}
