package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WindowType;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // First website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Second tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://automationexercise.com/");
        Thread.sleep(3000);

        // Third tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practicetestautomation.com/");
        Thread.sleep(3000);

    }
}
