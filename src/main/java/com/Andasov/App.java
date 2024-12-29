package com.Andasov;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class App {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public App() {
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

        WebElement submitButton2 = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]/input"));
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

    public void waitVariations() {
        try {
            driver.get("https://www.twitch.tv/");

            // 1. Implicit Wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement implicitElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div[1]/div[2]/div/div/div[1]/a"));
            System.out.println("Implicit Wait Element Text: " + implicitElement.getText());
            implicitElement.click();

            // 2. Explicit Wait
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement explicitElement = explicitWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"browse-root-main-content\"]/div[4]/div/div[1]/div[5]/div/div/div/div/div[1]/div/a")));
            System.out.println("Explicit Wait Element Text: " + explicitElement.getText());
            explicitElement.click();

            // 3. Fluent Wait
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement fluentElement = fluentWait.until(
                    webDriver -> webDriver.findElement(By.xpath("//*[@id=\"directory-game-main-content\"]/div[1]/div[2]/div/div[2]/div[4]/div[2]/a")));
            System.out.println("Fluent Wait Element Text: " + fluentElement.getText());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void actionsInWeb() {
        driver.get("https://warframe.fandom.com/wiki/WARFRAME_Wiki");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement hover1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[4]/div[2]/header/nav/ul/li[3]/div[1]")));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(hover1).perform();

        WebElement hover2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[4]/div[2]/header/nav/ul/li[3]/div[2]/ul/li[3]/a")));
        
        actions.moveToElement(hover2).perform();

        WebElement click1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[4]/div[2]/header/nav/ul/li[3]/div[2]/ul/li[3]/div/ul/li[4]/a")));
        click1.click();

        WebElement link1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/div[4]/div[1]/a[2]")));

        actions.contextClick(link1).perform();

        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"global-top-navigation\"]/div[1]/div/input"));
        actions.keyDown(Keys.SHIFT).click(searchField).sendKeys("Gauss").keyUp(Keys.SHIFT).sendKeys(Keys.ENTER).perform();
        
        WebElement link2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.unified-search__result__title")));
        actions.moveToElement(link2).doubleClick().perform();

        WebElement hover1Element = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/div[3]/div/div[2]/div/p[4]"));
        actions.moveToElement(hover1Element).click().perform();

    }

    public void selectOptions() {
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement advSearch = driver.findElement(By.xpath("//*[@id=\"gh-as-a\"]"));
        advSearch.click();

        WebElement multiselect1 = driver.findElement(By.xpath("//*[@id=\"s0-1-17-4[0]-7[3]-_sacat\"]")); 
        Select select1 = new Select(multiselect1);

        select1.selectByVisibleText("Книги и журналы");

        WebElement multiselect2 = driver.findElement(By.xpath("//*[@id=\"s0-1-17-5[5]-3[@field[]]-1[0]-_ftrt\"]")); 
        Select select2 = new Select(multiselect2);

        select2.selectByIndex(1);

        WebElement multiselect3 = driver.findElement(By.xpath("//*[@id=\"s0-1-17-5[5]-3[@field[]]-1[1]-_ftrv\"]")); 
        Select select3 = new Select(multiselect3);

        select3.selectByValue("12");

        java.util.List<WebElement> selectedOptions = select2.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println("Selected Option: " + option.getText());
        }

        if (select2.getFirstSelectedOption().getText().equals("Завершающиеся через более чем")) {
            System.out.println("Завершающиеся через более чем is selected.");
        } else {
            System.out.println("Завершающиеся через более чем is not selected.");
        }
    }
}
