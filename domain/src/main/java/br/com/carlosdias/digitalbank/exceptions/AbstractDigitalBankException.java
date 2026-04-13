package br.com.carlosdias.digitalbank.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class AbstractDigitalBankException extends RuntimeException {
    private final String errorCode;

    public AbstractDigitalBankException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
