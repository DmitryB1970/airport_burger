package com.javaacademy.burger.unit;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.Currency.RUB;
import static com.javaacademy.burger.dish.DishType.BURGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Проверка работы ресторана")
public class SteakhouseIntegrationTest {

    private Steakhouse steakhouse = new Steakhouse(new Waitress(), new Kitchen(), new PayTerminal());

    @Test
    @DisplayName("Успешная выдача бургера")
    public void successOrderBurger() {
        Paycheck paycheck = steakhouse.makeOrder(BURGER, RUB);
        PaycheckUtil.checkPaycheck(paycheck, BURGER,
                paycheck.getTotalAmount(), paycheck.getCurrency());
        Dish dish = steakhouse.takeOrder(paycheck);
        assertNotNull(dish);
        assertEquals(BURGER, dish.getDishType());
    }
}
