package br.com.carlosdias.digitalbank.responses;

import java.math.BigDecimal;

public record AccountResponse(
        BigDecimal balance,
        String name
) {
}
