package br.com.carlosdias.digitalbank.exceptions;

import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.ACCOUNT_NAME_CANNOT_BE_EMPTY_ERROR_CODE;

public class AccountNameCannotBeEmptyException extends AbstractDigitalBankException {
    public AccountNameCannotBeEmptyException() {
        super(ACCOUNT_NAME_CANNOT_BE_EMPTY_ERROR_CODE, "Account name cannot be empty");
    }
}
