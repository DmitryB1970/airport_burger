package com.javaacademy.burger.it;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;
import static org.mockito.ArgumentMatchers.any;

@DisplayName("Проверка из налоговой инспекции")
public class TaxInspectionIT {

    @Test
    @DisplayName("Успешный заказ ребер за рубли")
    public void orderSuccess() {
        Kitchen mockKitchen = Mockito.mock(Kitchen.class);
        Mockito.doNothing().when(mockKitchen).cook(any(DishType.class));
        Waitress mockWaitress = Mockito.mock(Waitress.class);
        Mockito.when(mockWaitress.giveOrderToKitchen(any(DishType.class), any(Kitchen.class)))
                .thenReturn(true);
        PayTerminal payTerminal = new PayTerminal();
        Steakhouse steakhouse = new Steakhouse(mockWaitress, mockKitchen, payTerminal);
        Paycheck paycheck = steakhouse.makeOrder(DishType.RIBS, Currency.RUB);
        Paycheck expected = new Paycheck(BigDecimal.valueOf(700), Currency.RUB, DishType.RIBS);
        Assertions.assertEquals(expected, paycheck);
    }

    @Test
    @DisplayName("Успешная покупка за доллары")
    public void orderPotatoesForDollarsSuccess() {
        Kitchen mockKitchen = Mockito.mock(Kitchen.class);
        Mockito.doNothing().when(mockKitchen).cook(any(DishType.class));
        Waitress mockWaitress = Mockito.mock(Waitress.class);
        Mockito.when(mockWaitress.giveOrderToKitchen(any(DishType.class), any(Kitchen.class))).thenReturn(true);
        PayTerminal payTerminalSpy = Mockito.spy(PayTerminal.class);
        Paycheck returnedCheck = new Paycheck(BigDecimal.valueOf(1), Currency.USD, DishType.FRIED_POTATO);
        Mockito.doReturn(returnedCheck).when(payTerminalSpy).pay(DishType.FRIED_POTATO, Currency.USD);
        Steakhouse steakhouse = new Steakhouse(mockWaitress, mockKitchen, payTerminalSpy);
        Paycheck check = steakhouse.makeOrder(DishType.FRIED_POTATO, Currency.USD);
        Assertions.assertEquals(returnedCheck, check);
    }

    @Test
    @DisplayName("Успешная покупка бургера за мозамбикские доллары")
    public void orderBurgerForMozabicanDollarsSuccess() {
        Kitchen mockKitchen = Mockito.mock(Kitchen.class);
        Mockito.doNothing().when(mockKitchen).cook(any(DishType.class));
        Waitress mockWaitress = Mockito.mock(Waitress.class);
        Mockito.when(mockWaitress.giveOrderToKitchen(any(DishType.class), any(Kitchen.class))).thenReturn(true);
        PayTerminal payTerminalSpy = Mockito.spy(PayTerminal.class);
        Paycheck clientCheck = new Paycheck(BigDecimal.valueOf(1), Currency.MOZAMBICAN_DOLLARS, DishType.BURGER);
        Mockito.doReturn(clientCheck).when(payTerminalSpy).pay(DishType.BURGER, Currency.MOZAMBICAN_DOLLARS);
        Steakhouse steakhouse = new Steakhouse(mockWaitress, mockKitchen, payTerminalSpy);
        Paycheck check = steakhouse.makeOrder(DishType.BURGER, Currency.MOZAMBICAN_DOLLARS);
        Paycheck expected = clientCheck;
        Assertions.assertEquals(expected, check);
    }
}
