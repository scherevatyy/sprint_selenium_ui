package org.example.pages;

import org.example.model.OrderDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
//        **Локаторы элементов первой страницы заказа**
//        Имя
        private final By firstNameInput = By.xpath("//input[@placeholder='* Имя']");

//        Фамилия
        private final By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");

//        Адрес
        private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

//        Станция метро
        private final By metroInput = By.xpath("//input[@placeholder='* Станция метро']");

//        Телефон
        private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

//        Кнопка Далее
        private final By nextButton = By.xpath("//button[text()='Далее']");


    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetro(String metro) {
        driver.findElement(metroInput).click();
        driver.findElement(metroInput).sendKeys(metro);
        By metroOption = By.xpath("//div[text()='" + metro + "']");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroOption))
                .click();
    }

    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public OrderPage fillFirstStep(OrderDTO order) {
        setFirstName(order.getFirstName());
        setLastName(order.getLastName());
        setAddress(order.getAddress());
        selectMetro(order.getMetroStation());
        setPhone(order.getPhone());
        return this;
    }
}


