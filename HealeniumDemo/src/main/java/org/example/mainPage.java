package org.example;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.time.Duration;


public class mainPage extends basePage {

    private static SelfHealingDriver driver;
    static ChromeOptions options = new ChromeOptions();
    protected static String Url = "https://member-stage6.impactradius.net/";
    static String getBrowserName = options.getBrowserName();
    static String getBrowserVersion = options.getBrowserVersion();
    static String getCapabilityNames = options.getCapabilityNames().toString();
    public static final Logger log = LoggerFactory.getLogger(mainPage.class);

    public mainPage(SelfHealingDriver driver) {
        super(driver);
    }

    public mainPage() {
        this(driver);
    }

    public static void SetUp(){
        WebDriverManager.chromedriver().driverVersion("109.0").setup();
        options.setHeadless(false);

        WebDriver delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);

        log.info("BROWSER: " + getBrowserName);
        log.info("BROWSER VERSION: " + getBrowserVersion);
        log.info("CAPABILITY NAMES: " + getCapabilityNames);

        driver.navigate().to(Url);
        log.info("Navigated to stage-6 successfully!!");

    }

    public mainPage login(){

        waitForElementToBeVisibleByXpath("//div[@class='loginLogo']");
        driver.findElement(By.id("j_username")).sendKeys("Phindile");
        driver.findElement(By.id("j_password")).sendKeys("5umbrella9");
        driver.findElement(By.id("loginButton")).click();

        return new mainPage(driver);
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public void waitForElementToBeVisibleByXpath(String xpath) {

        FluentWait<SelfHealingDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        By elementLocator = By.xpath(xpath);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));

    }
    /**
     * // Example using Time Interval
     * WebDriverWait timeWait = new WebDriverWait(driver, 10);
     * element = timeWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
     * */


}