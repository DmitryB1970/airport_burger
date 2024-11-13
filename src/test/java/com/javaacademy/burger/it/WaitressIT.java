package com.javaacademy.burger.it;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.Waitress;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

@DisplayName("Проверка работы официанта")
public class WaitressIT {

    @Test
    @DisplayName("Официант успешно принял заказ на бургер")
    public void giveOrderToKitchenSuccess() {
        Kitchen kitchenMock = Mockito.mock(Kitchen.class);
        Mockito.doNothing().when(kitchenMock).cook(any(DishType.class));
        Waitress waitress = new Waitress();
        DishType dishType = DishType.BURGER;
        Assertions.assertDoesNotThrow(() -> waitress.giveOrderToKitchen(dishType, kitchenMock));
    }

    @Test
    @DisplayName("Ошибка при заказе фуагры")
    public void giveOrderToKitchenFailure() {
        Waitress waitress = new Waitress();
        Kitchen kitchenMock = Mockito.mock();
        Mockito.doNothing().when(kitchenMock).cook(any(DishType.class));
        DishType dishType = DishType.FUAGRA;
        boolean expected = false;
        boolean result = waitress.giveOrderToKitchen(dishType, kitchenMock);
        Assertions.assertEquals(expected,result);
    }
}
