package page;

import lombok.Getter;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

@Getter
public class EmailGeneratorPage extends AbstractPage {

    private final FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
    private final Logger log = LogManager.getRootLogger();

    @FindBy(id = "email_ch_text")
    private WebElement emailAddress;

    @FindBy(xpath = "//h2[contains(text(), 'Estimated Monthly Cost')]")
    private WebElement estimatedCostFromEmail;

    public EmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public void openEmailGeneratorPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        log.info("Opening email generator page");
        driver.get("https://generator.email/inbox2/");
        fluentWait.until(ExpectedConditions.visibilityOf(emailAddress));
    }

    public String getEmailAddress() {
        log.info("Getting generated email");
        String generatedEmail = emailAddress.getText();
        return generatedEmail;
    }

}
