package org.example.pages;

import org.example.enums.ScooterColor;
import org.example.model.OrderDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {
    private final WebDriver driver;
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

//    **Локаторы элементов второй страницы заказа**
//    Хидер формы заказа. Для фикса проблемы с закрытием календаря
    private final By formTitle = By.className("Order_Header__BZXOb");

//    Дата доставки
    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");

//    Срок аренды
    private final By rentPeriodDropdown = By.className("Dropdown-control");

//    Комментарий
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");

//    Кнопка "Заказать"
    private final By orderButton = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");

//    Кнопка подтверждения "Да"
    private final By confirmButton = By.xpath("//button[text()='Да']");

//    Окно успешного заказа
    private final By successModal = By.id("Order_Modal__YZ-d3");
    private final By successModalText = By.className("Order_ModalHeader__3FDaJ");


    public void createOrder() {
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmButton))
                .click();
    }

    public boolean isSuccessModalDisplayed() {
        return driver.findElement(successModal).isDisplayed();
    }

    public String getSuccessModalText() {
        return driver.findElement(successModalText).getText();
    }

    public RentPage fillForm(OrderDTO order) {
        driver.findElement(dateInput).sendKeys(order.getDate().toString());
        driver.findElement(formTitle).click();
        driver.findElement(rentPeriodDropdown).click();
        driver.findElement(By.xpath("//div[text()='" + order.getRentalPeriod().getUiText() + "']")).click();

        for (ScooterColor color : order.getColors()) {
            driver.findElement(By.id(color.getCheckboxId())).click();
        }

        driver.findElement(commentInput).sendKeys(order.getComment());

        return this;
    }
}
