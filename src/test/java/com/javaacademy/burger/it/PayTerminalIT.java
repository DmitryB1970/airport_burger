package com.javaacademy.burger.it;


import com.javaacademy.burger.Currency;
import com.javaacademy.burger.PayTerminal;
import com.javaacademy.burger.dish.DishType;
import com.javaacademy.burger.exception.NotAcceptedCurrencyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка работы терминала оплаты")
public class PayTerminalIT {

    @Test
    @DisplayName("Успешная оплата бургера")
    public void paySuccess() {
        PayTerminal payTerminal = new PayTerminal();
        DishType dishType = DishType.BURGER;
        Assertions.assertDoesNotThrow(() -> payTerminal.pay(dishType, Currency.RUB));
    }

    @Test
    @DisplayName("Неуспешная оплата заказа в мозамбикских долларах")
    public void payFailure() {
        PayTerminal payTerminal = new PayTerminal();
        DishType dishType = DishType.BURGER;
        Assertions.assertThrows(NotAcceptedCurrencyException.class,
                () -> payTerminal.pay(dishType, Currency.MOZAMBICAN_DOLLARS));
    }
}
