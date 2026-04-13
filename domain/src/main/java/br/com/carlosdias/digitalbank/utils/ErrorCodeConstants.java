package br.com.carlosdias.digitalbank.utils;

public final class ErrorCodeConstants {

    public static final String METHOD_ARGUMENT_NOT_VALID_ERROR_CODE = "DB-001";
    public static final String ACCOUNT_NAME_CANNOT_BE_EMPTY_ERROR_CODE = "DB-002";
    public static final String ACCOUNT_BALANCE_INVALID_VALUE_ERROR_CODE = "DB-003";
    public static final String TRANSFER_TO_SAME_ACCOUNT_ERROR_CODE = "DB-004";
    public static final String INSUFFICIENT_BALANCE_OR_ACCOUNT_NOT_FOUND_ERROR_CODE = "DB-005";
    public static final String ACCOUNT_NOT_FOUND_ERROR_CODE = "DB-006";
    public static final String UNKNOWN_ERROR_CODE = "DB-999";

    private ErrorCodeConstants() {
    }
}
