package com.javaacademy.burger.it;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.dish.DishType;
import com.javaacademy.burger.exception.KitchenHasNoGasException;
import com.javaacademy.burger.exception.UnsupportedDishTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Проверка работы кухни")
public class KitchenIT {

    @Test
    @DisplayName("Кухня успешно приготовила бургер")
    public void cookSuccess() {
        Kitchen kitchen = new Kitchen();
        DishType dishType = DishType.BURGER;
        Assertions.assertDoesNotThrow(() -> kitchen.cook(dishType));
    }

    @Test
    @DisplayName("Ошибка из-за выключения газа")
    public void cookBurgerFailure() {
        Kitchen kitchen = new Kitchen();
        DishType dishType = DishType.BURGER;
        kitchen.setHasGas(false);
        Assertions.assertThrows(KitchenHasNoGasException.class, () -> kitchen.cook(dishType));
    }

    @Test
    @DisplayName("Ошибка из-за неумения готовить фуагру")
    public void cookFuagraFailure() {
        Kitchen kitchen = new Kitchen();
        DishType dishType = DishType.FUAGRA;
        Assertions.assertThrows(UnsupportedDishTypeException.class, () -> kitchen.cook(dishType));
    }
}
