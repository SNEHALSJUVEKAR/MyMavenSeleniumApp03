package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    WebDriver driver;

    @Before
    public void setUp() {

        // Automatically manages ChromeDriver (NO manual path needed)
        WebDriverManager.chromedriver().setup();

        // Headless Chrome setup (important for Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testLogin() throws InterruptedException {

        // Open login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username
        driver.findElement(By.id("username")).sendKeys("student");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click login
        driver.findElement(By.id("submit")).click();

        // Wait for page to load
        Thread.sleep(2000);

        // Validate login success
        String currentUrl = driver.getCurrentUrl();

        assertTrue("Login Failed!", currentUrl.contains("logged-in-successfully"));

        System.out.println("Test Passed: Login Successful");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
