package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

//     **Локаторы элементов главной страницы**
//    Кнопка "Заказать" в хидере страницы
    private final By orderButtonTop = By.className("Button_Button__ra12g");

//    Кнопка "Заказать" внизу страницы
    private final By orderButtonBottom = By.className("Button_Middle__1CSJM");

//    Вопросы в разделе FAQ
    private final By faqQuestion = By.className("accordion__button");

//    Ответ в разделе FAQ
    private final By faqAnswer = By.className("accordion__panel");

//    Кнопка принятия Куки
    private final By acceptCookiesButton = By.className("App_CookieButton__3cvqF");


    public void clickOrderButtonTop() {

        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void clickFaqQuestion(int index) {
        WebElement question = driver.findElements(faqQuestion).get(index);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", question);

        question.click();
    }

    public String getFaqAnswerText(int index) {
        return driver.findElements(faqAnswer)
                .get(index)
                .getText()
                .replace("\u00A0", " ")
                .replace("\n", " ")
                .trim();
    }

    public MainPage acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement button = wait.until(
                    ExpectedConditions.elementToBeClickable(acceptCookiesButton)
            );
            button.click();
        } catch (TimeoutException ignored) {
        }
        return this;
    }
}
