package org.example.tests;

import org.example.model.OrderDTO;
import org.example.pages.MainPage;
import org.example.pages.OrderPage;
import org.example.pages.RentPage;
import org.example.utils.BaseTest;
import org.example.utils.TestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OrderTest extends BaseTest {

    static Stream<OrderDTO> orderData() {
        return Stream.of(
                TestDataFactory.validOrderOne(),
                TestDataFactory.validOrderTwo()
        );
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void shouldCreateOrderFromTopButton(OrderDTO order) {

        new MainPage(driver).clickOrderButtonTop();
        new OrderPage(driver).fillFirstStep(order).clickNextButton();

        RentPage rentPage = new RentPage(driver);
        rentPage.fillForm(order).createOrder();
        String successText = rentPage.getSuccessModalText();

        Assertions.assertAll(
                () -> Assertions.assertTrue(
                        successText.contains("Заказ оформлен"),
                        "Нет заголовка успешного заказа"
                ),
                () -> Assertions.assertTrue(
                        successText.contains("Номер заказа"),
                        "Нет текста с номером заказа"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void shouldCreateOrderFromBottomButton(OrderDTO order) {

        new MainPage(driver).acceptCookiesIfPresent().clickOrderButtonBottom();
        new OrderPage(driver).fillFirstStep(order).clickNextButton();

        RentPage rentPage = new RentPage(driver);
        rentPage.fillForm(order).createOrder();
        String successText = rentPage.getSuccessModalText();

        Assertions.assertAll(
                () -> Assertions.assertTrue(
                        successText.contains("Заказ оформлен"),
                        "Нет заголовка успешного заказа"
                ),
                () -> Assertions.assertTrue(
                        successText.contains("Номер заказа"),
                        "Нет текста с номером заказа"
                )
        );
    }
}