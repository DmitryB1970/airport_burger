package com.javaacademy.burger.unit;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.Waitress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.javaacademy.burger.dish.DishType.BURGER;
import static com.javaacademy.burger.dish.DishType.FUAGRA;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Проверка работы официанта")
public class WaitressTest {

    private Kitchen kitchenMock = Mockito.mock(Kitchen.class);
    private Waitress waitress = new Waitress();


    @Test
    @DisplayName("Успешный приём заказа на бургер")
    public void successTakeOrder() {

        boolean result = waitress.giveOrderToKitchen(BURGER, kitchenMock);
        assertTrue(result);
    }

    @Test
    @DisplayName("Успешный приём заказа на бургер")
    public void failTakeOrderFuagra() {

        boolean result = waitress.giveOrderToKitchen(FUAGRA, kitchenMock);
        assertFalse(result);
    }
}
