package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class App {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public App() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Andasov Temirlan\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void searchTest() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Selenium WebDriver");
        
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement seleniumResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h3.LC20lb.MBeuO.DKV0Md")));
        
        seleniumResult.click();

        System.out.println("Search test completed.");
    }

    public void loginLogout() {
        driver.get("https://online-go.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.sign-in")));
        signInElement.click();

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        usernameField.sendKeys("dalden");

        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passField.sendKeys("1234");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.primary")));
        signInButton.click();

        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='username'][text()='dalden']")));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(usernameElement).perform();
        
        WebElement signOutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='default-variant-container']/header/section[2]/section/div/span")));
        
        signOutElement.click();

        System.out.println("Login and logout completed.");
    }

    public void flightBooking() {
        driver.get("https://www.blazedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[3]/form/select[1]"));

        Select select = new Select(dropdown);

        select.selectByIndex(4);

        WebElement dropdown2 = driver.findElement(By.xpath("/html/body/div[3]/form/select[2]"));

        Select select2 = new Select(dropdown2);

        select2.selectByIndex(2);

        WebElement submitButton = driver.findElement(By.cssSelector("input.btn.btn-primary[value='Find Flights']"));
        submitButton.click();

        WebElement submitButton2 = driver.findElement(By.cssSelector("input.btn.btn-small[value='Choose This Flight']"));
        submitButton2.click();

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='inputName']")));
        usernameField.sendKeys("Temirlan");

        WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='address']")));
        addressField.sendKeys("123 My street");

        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
        cityField.sendKeys("Astana");

        WebElement stateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='state']")));
        stateField.sendKeys("Akmola");

        WebElement zipField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='zipCode']")));
        zipField.sendKeys("010000");

        WebElement dropdown3 = driver.findElement(By.xpath("//*[@id=\"cardType\"]"));

        Select select3 = new Select(dropdown3);

        select3.selectByIndex(1);

        WebElement creditField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='creditCardNumber']")));
        creditField.sendKeys("4000500030006000");

        WebElement monthField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='creditCardMonth']")));
        monthField.sendKeys("7");

        WebElement yearField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='creditCardYear']")));
        yearField.sendKeys("2024");

        WebElement nameOnCardField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nameOnCard']")));
        nameOnCardField.sendKeys("Temirlan Andassov");

        WebElement submitButton3 = driver.findElement(By.cssSelector("input.btn.btn-primary[value='Purchase Flight']"));
        submitButton3.click();
    }
}
