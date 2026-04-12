package br.com.carlosdias.digitalbank.handler;

import br.com.carlosdias.digitalbank.exceptions.AbstractDigitalBankException;
import br.com.carlosdias.digitalbank.responses.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.METHOD_ARGUMENT_NOT_VALID_ERROR_CODE;
import static br.com.carlosdias.digitalbank.utils.ErrorCodeConstants.UNKNOWN_ERROR_CODE;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.warn("m=handleMethodArgumentNotValidException, message={}", ex.getMessage());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        return new ApiError(
                400,
                METHOD_ARGUMENT_NOT_VALID_ERROR_CODE,
                "Validation error",
                errors,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(AbstractDigitalBankException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleAbstractDigitalBankException(AbstractDigitalBankException ex) {
        log.warn("m=handleAbstractDigitalBankException, message={}", ex.getMessage());

        return new ApiError(
                400,
                ex.getErrorCode(),
                ex.getMessage(),
                null,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleGenericException(Exception ex) {
        log.error("m=handleGenericException, message={}", ex.getMessage(), ex);

        return new ApiError(
                500,
                "Internal server error",
                UNKNOWN_ERROR_CODE,
                null,
                LocalDateTime.now()
        );
    }
}
