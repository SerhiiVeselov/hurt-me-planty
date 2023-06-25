package testng;

import driver.DriverSingleton;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import page.EmailGeneratorPage;
import page.MainPage;
import page.PricingCalculatorPage;
import page.SearchResultsPage;
import util.TestListener;

import java.time.Duration;

@Listeners({TestListener.class})
public class CommonConditions {

    protected static WebDriver driver;
    public static FluentWait<WebDriver> fluentWait;
    public static MainPage mainPage;
    public static SearchResultsPage searchResultsPage;
    public static PricingCalculatorPage pricingCalculatorPage;
    public static EmailGeneratorPage emailGeneratorPage;

    @BeforeSuite
    public static void setUp() {
        driver = DriverSingleton.getDriver();

        mainPage = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        pricingCalculatorPage = new PricingCalculatorPage(driver);
        emailGeneratorPage = new EmailGeneratorPage(driver);

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    @AfterSuite
    public static void stopBrowser() {
        DriverSingleton.closeDriver();
    }

}
