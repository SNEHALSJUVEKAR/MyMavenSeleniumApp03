package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WindowType;

public class App {

    public static void main(String[] args) {

        // Set ChromeDriver path (update if needed)
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Chrome headless setup (important for Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Maximize (optional in headless)
            driver.manage().window().maximize();

            // First website
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            // Second tab
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://automationexercise.com/");
            Thread.sleep(2000);

            // Third tab
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/");
            Thread.sleep(2000);

            System.out.println("All tabs opened successfully in headless Chrome!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
