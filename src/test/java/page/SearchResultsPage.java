package page;

import lombok.Getter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

@Getter
public class SearchResultsPage extends AbstractPage {

    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
    PricingCalculatorPage pricingCalculatorPage = new PricingCalculatorPage(driver);
    private final Logger log = LogManager.getRootLogger();

    @FindBy(xpath = "//article[@class='devsite-article-inner']")
    private WebElement searchResultsTab;

    @FindBy(xpath = "//a/b[text()='Google Cloud Pricing Calculator']")
    private WebElement pricingCalculatorLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickPricingCalculatorLink() {
        log.info("Clicking the Pricing Calculator link");
        pricingCalculatorLink.click();
    }

}
