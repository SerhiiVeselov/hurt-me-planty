package page;

import lombok.Getter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import util.Highlighter;

@Getter
public class MainPage extends AbstractPage {

    private final FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
    private final Logger log = LogManager.getRootLogger();

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement cookiesOkBtn;

    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchBtn;

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"suggestion-partial-query-2\"]/a/span")
    private WebElement suggestSearchResult;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        log.info("Opening Google Cloud web page");
        driver.get("https://cloud.google.com/");
    }

    public void closeCookiesPopUp() {
        try {
            if (cookiesOkBtn.isDisplayed()) {
                Highlighter.HighlightElement(driver, cookiesOkBtn);
                cookiesOkBtn.click();
                log.info("Closing cookies pop-up");
                fluentWait.until(ExpectedConditions.invisibilityOf(cookiesOkBtn));
            }
        }
        catch (NoSuchElementException e) {

        }
    }

    public void openSearchField() {
        log.info("Opening Search field");
        searchBtn.click();
    }

    public void enterSearchRequest() {
        log.info("Entering the search request");
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
    }

    public void clickSuggestSearchResult() {
        log.info("Selecting suggested search results");
        suggestSearchResult.click();
    }

}
