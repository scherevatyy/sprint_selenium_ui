package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        String browser = System.getProperty("browser");
        if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        }
        // по умолчанию Chrome
        return new ChromeDriver();
    }
}