package com.Andasov;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {

    private static App app;
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        app = new App();
        driver = app.getDriver();
    }

    // @Test
    // @Order(1)
    // public void testSearchFunctionality() {
    //     app.searchTest();

    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //     wait.until(ExpectedConditions.urlContains("selenium.dev/documentation/webdriver"));

    //     String currentUrl = driver.getCurrentUrl();
    //     assertTrue(currentUrl.contains("selenium.dev/documentation/webdriver"), 
    //                "The page should be the Selenium WebDriver documentation");

    //     wait.until(ExpectedConditions.titleContains("WebDriver"));

    //     String pageTitle = driver.getTitle();
    //     System.out.println("Page Title: " + pageTitle);

    //     assertTrue(pageTitle.toLowerCase().contains("selenium"), 
    //                "Search results page title should contain 'selenium'");

    //     System.out.println("Search functionality test passed. Successfully navigated to Selenium documentation.");
    // }

    // @Test
    // @Order(2)
    // public void testLoginLogout() {
    //     app.loginLogout();

    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //     WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
    //             By.xpath("//span[@class='username'][text()='dalden']")));

    //     assertNotNull(usernameElement, "Username should be visible after login.");

    //     WebElement signOutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
    //             By.xpath("//*[@id='default-variant-container']/header/section[2]/section/div/span")));
        
    //     signOutElement.click();

    //     wait.until(ExpectedConditions.urlContains("https://online-go.com/sign-in"));

    //     System.out.println("Login and logout completed successfully.");
    // }

    // @Test
    // @Order(3)
    // public void testFlightBooking() {
    //     app.flightBooking();

    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //     wait.until(ExpectedConditions.urlToBe("https://www.blazedemo.com/confirmation.php"));

    //     assertEquals("https://www.blazedemo.com/confirmation.php", driver.getCurrentUrl(), "User is not redirected to the confirmation page");

    //     WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you for your purchase today!']")));
    //     assertNotNull(confirmationMessage, "Confirmation message should be displayed on the confirmation page");

    //     System.out.println("Flight booking test passed.");
    // }

    @Test
    @Order(1)
    public void testWaitVariations() {
        app.waitVariations();
    }

    @Test
    @Order(2)
    public void testActionsInWeb() {
        app.actionsInWeb();
    }

    @Test
    @Order(3)
    public void testSelectOptions() {
        app.selectOptions();
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
