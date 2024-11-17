package com.javaacademy.burger.unit;

import com.javaacademy.burger.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.Currency.*;
import static com.javaacademy.burger.dish.DishType.*;
import static com.javaacademy.burger.unit.PaycheckUtil.checkPaycheck;
import static java.math.BigDecimal.valueOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Проверка из налоговой инспекции")
public class SteakHouseTaxServiceIntegrationTest {

    private Kitchen mockKitchen = mock(Kitchen.class);
    private Waitress mockWaitress = mock(Waitress.class);
    private PayTerminal payTerminalSpy = spy(PayTerminal.class);
    private Steakhouse steakhouse = new Steakhouse(mockWaitress, mockKitchen, payTerminalSpy);

    public SteakHouseTaxServiceIntegrationTest() {
        when(mockWaitress.giveOrderToKitchen(any(), any())).thenReturn(true);
    }

    @Test
    @DisplayName("Успешный заказ ребер за рубли")
    public void orderSuccess() {
        Paycheck paycheck = steakhouse.makeOrder(RIBS, RUB);
        checkPaycheck(paycheck, RIBS, valueOf(700), RUB);
    }

    @Test
    @DisplayName("Успешный заказ картошки за доллары")
    public void successOrderPotatoesInDollars() {

        doReturn(new Paycheck(valueOf(1), USD, FRIED_POTATO)).when(payTerminalSpy).pay(FRIED_POTATO, USD);
        Paycheck paycheck = steakhouse.makeOrder(FRIED_POTATO, USD);
        checkPaycheck(paycheck, FRIED_POTATO, valueOf(1), USD);
    }

    @Test
    @DisplayName("Успешная покупка бургера за мозамбикские доллары")
    public void successOrderBurgerForMozabicDollars() {

        doReturn(new Paycheck(valueOf(1), MOZAMBICAN_DOLLARS, BURGER))
                .when(payTerminalSpy).pay(BURGER, MOZAMBICAN_DOLLARS);
        Paycheck paycheck = steakhouse.makeOrder(BURGER, MOZAMBICAN_DOLLARS);
        checkPaycheck(paycheck, BURGER, valueOf(1), MOZAMBICAN_DOLLARS);
    }
}
