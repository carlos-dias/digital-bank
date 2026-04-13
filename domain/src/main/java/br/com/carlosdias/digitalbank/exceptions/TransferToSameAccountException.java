package br.com.carlosdias.digitalbank.exceptions;

import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.TRANSFER_TO_SAME_ACCOUNT_ERROR_CODE;

public class TransferToSameAccountException extends AbstractDigitalBankException {
    public TransferToSameAccountException() {
        super(TRANSFER_TO_SAME_ACCOUNT_ERROR_CODE, "Cannot transfer to the same account");
    }
}
