package com.javaacademy.burger.unit;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.exception.KitchenHasNoGasException;
import com.javaacademy.burger.exception.UnsupportedDishTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.dish.DishType.BURGER;
import static com.javaacademy.burger.dish.DishType.FUAGRA;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Проверка работы кухни")
public class KitchenTest {

    private Kitchen kitchen = new Kitchen();

    @Test
    @DisplayName("Успешное приготовление бургера")
    public void successCookBurger() {

        assertEquals(0, kitchen.getCompletedDishes().size());
        kitchen.cook(BURGER);
        assertEquals(1, kitchen.getCompletedDishes().size());

        Dish dish = kitchen.getCompletedDishes().get(BURGER).poll();
        assertNotNull(dish);
        assertEquals(BURGER, dish.getDishType());
    }


    @Test
    @DisplayName("Невозможно приготовить бургер без газа")
    public void failCookBurgerWithoutGas() {

        kitchen.setHasGas(false);
        assertThrows(KitchenHasNoGasException.class, () -> kitchen.cook(BURGER));

    }

    @Test
    @DisplayName("Невозможно приготовить фуагра")
    public void failCookFuagra() {

        kitchen.setHasGas(false);
        assertThrows(UnsupportedDishTypeException.class, () -> kitchen.cook(FUAGRA));
    }
}
