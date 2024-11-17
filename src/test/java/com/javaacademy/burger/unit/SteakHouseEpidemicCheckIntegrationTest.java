package com.javaacademy.burger.unit;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.javaacademy.burger.Currency.RUB;
import static com.javaacademy.burger.dish.DishType.RIBS;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;


@DisplayName("Проверка качества еды санэпидемстанцией")
public class SteakHouseEpidemicCheckIntegrationTest {

    @Test
    @DisplayName("Успешный заказ рёбер")
    public void checkDishSuccess() {

        PayTerminal mockPayterminal = Mockito.mock(PayTerminal.class);
        Steakhouse steakhouse = new Steakhouse(new Waitress(), new Kitchen(), mockPayterminal);
        Mockito.when(mockPayterminal.pay(any(), any())).thenReturn(new Paycheck(valueOf(700),
                RUB, RIBS));

        Paycheck paycheck = steakhouse.makeOrder(RIBS, RUB);
        Dish dish = steakhouse.takeOrder(paycheck);
        assertNotNull(dish);
        Paycheck result = mockPayterminal.pay(RIBS, RUB);
        assertEquals(RIBS, dish.getDishType());
    }
}
