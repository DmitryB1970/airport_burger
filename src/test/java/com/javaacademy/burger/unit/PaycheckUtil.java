package com.javaacademy.burger.unit;

import com.javaacademy.burger.Currency;
import com.javaacademy.burger.Paycheck;
import com.javaacademy.burger.dish.DishType;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaycheckUtil {

    public static void checkPaycheck(Paycheck resultPaycheck,
                                     DishType expectedDishType,
                                     BigDecimal expectedTotalAmount,
                                     Currency expectedCurrency) {

        assertEquals(expectedDishType, resultPaycheck.getDishType());
        int resultCompare = resultPaycheck.getTotalAmount().compareTo(expectedTotalAmount);
        assertEquals(0, resultCompare);
        assertEquals(expectedCurrency, resultPaycheck.getCurrency());
    }
}
