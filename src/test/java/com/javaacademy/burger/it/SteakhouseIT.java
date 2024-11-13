package com.javaacademy.burger.it;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка работы ресторана")
public class SteakhouseIT {

    @Test
    @DisplayName("Успешная проверка чека")
    public void checkPaycheckSuccess() {
        Waitress waitress = new Waitress();
        Kitchen kitchen = new Kitchen();
        PayTerminal payTerminal = new PayTerminal();
        Steakhouse steakhouse = new Steakhouse(waitress, kitchen, payTerminal);
        Paycheck expected = new Paycheck(DishType.BURGER.getPrice(), Currency.RUB, DishType.BURGER);
        Paycheck paycheckForOrder = steakhouse.makeOrder(DishType.BURGER, Currency.RUB);
        waitress.takeDishFromKitchen(DishType.BURGER, kitchen);
        Assertions.assertEquals(expected, paycheckForOrder);
    }


    @Test
    @DisplayName("Успешная проверка соответствия блюда в заказе")
    public void checkDishSuccess() {
        Waitress waitress = new Waitress();
        Kitchen kitchen = new Kitchen();
        PayTerminal payTerminal = new PayTerminal();
        DishType dishType = DishType.BURGER;
        Currency currencyRub = Currency.RUB;
        Steakhouse steakhouse = new Steakhouse(waitress, kitchen, payTerminal);
        Paycheck paycheckForOrder = steakhouse.makeOrder(dishType, currencyRub);
        Dish dish = steakhouse.takeOrder(paycheckForOrder);
        Assertions.assertEquals(dishType, dish.getDishType());
    }
}
