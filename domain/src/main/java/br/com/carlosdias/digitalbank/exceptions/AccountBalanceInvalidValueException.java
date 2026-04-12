package br.com.carlosdias.digitalbank.exceptions;

import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.ACCOUNT_BALANCE_INVALID_VALUE_ERROR_CODE;

public class AccountBalanceInvalidValueException extends AbstractDigitalBankException {
    public AccountBalanceInvalidValueException() {
        super(ACCOUNT_BALANCE_INVALID_VALUE_ERROR_CODE, "Account balance invalid value");
    }
}
