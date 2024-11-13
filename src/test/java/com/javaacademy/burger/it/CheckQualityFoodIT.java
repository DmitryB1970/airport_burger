package com.javaacademy.burger.it;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;


@DisplayName("Проверка качества еды санэпидемстанцией")
public class CheckQualityFoodIT {

    @Test
    @DisplayName("Успешный заказ рёбер клиентом")
    public void checkPaycheckSuccess() {
        Kitchen kitchen = new Kitchen();
        Waitress waitress = new Waitress();
        PayTerminal mockPayterminal = Mockito.mock(PayTerminal.class);
        Mockito.when(mockPayterminal.pay(DishType.RIBS, Currency.RUB)).thenReturn(new Paycheck(BigDecimal.valueOf(700),
                Currency.RUB, DishType.RIBS));
        Steakhouse steakhouse = new Steakhouse(waitress, kitchen, mockPayterminal);
        Paycheck expected = steakhouse.makeOrder(DishType.RIBS, Currency.RUB);
        Paycheck result = mockPayterminal.pay(DishType.RIBS, Currency.RUB);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка соответствия блюда")
    public void checkDishSuccess() {
        Kitchen kitchen = new Kitchen();
        Waitress waitress = new Waitress();
        PayTerminal mockPayterminal = Mockito.mock(PayTerminal.class);
        Mockito.when(mockPayterminal.pay(DishType.RIBS, Currency.RUB)).thenReturn(new Paycheck(BigDecimal.valueOf(700),
                Currency.RUB, DishType.RIBS));
        Steakhouse steakhouse = new Steakhouse(waitress, kitchen, mockPayterminal);
        steakhouse.makeOrder(DishType.RIBS, Currency.RUB);
        Paycheck result = mockPayterminal.pay(DishType.RIBS, Currency.RUB);
        Dish dish = steakhouse.takeOrder(result);
        Assertions.assertEquals(DishType.RIBS, dish.getDishType());
    }
}
