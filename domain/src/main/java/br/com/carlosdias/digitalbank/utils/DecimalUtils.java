package br.com.carlosdias.digitalbank.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DecimalUtils {

    public static BigDecimal toDecimal(Long value) {
        if (value == null)
            return BigDecimal.ZERO;
        return BigDecimal.valueOf(value, 2);
    }

    public static Long toLong(BigDecimal value) {
        if (value == null)
            return 0L;
        return value.setScale(2, RoundingMode.HALF_EVEN)
                .movePointRight(2)
                .longValueExact();
    }

    private DecimalUtils() {
    }
}
