package com.javaacademy.burger.unit;


import com.javaacademy.burger.PayTerminal;
import com.javaacademy.burger.Paycheck;
import com.javaacademy.burger.exception.NotAcceptedCurrencyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.Currency.MOZAMBICAN_DOLLARS;
import static com.javaacademy.burger.Currency.RUB;
import static com.javaacademy.burger.dish.DishType.BURGER;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Проверка работы терминала оплаты")
public class PayTerminalTest {

    private PayTerminal payTerminal = new PayTerminal();

    @Test
    @DisplayName("Успешная оплата бургера в рублях")
    public void successPayBurgerInRubles() {

        Paycheck paycheck = payTerminal.pay(BURGER, RUB);
        PaycheckUtil.checkPaycheck(paycheck, paycheck.getDishType(), paycheck.getTotalAmount(), paycheck.getCurrency());
    }

    @Test
    @DisplayName("Оплата в мозамбикских долларах невозможна")
    public void failPayBurgerInMozambicDollars() {

        assertThrows(NotAcceptedCurrencyException.class, () -> payTerminal.pay(BURGER, MOZAMBICAN_DOLLARS));

    }
}
