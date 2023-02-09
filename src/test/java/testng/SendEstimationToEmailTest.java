package testng;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;


public class SendEstimationToEmailTest extends CommonConditions {

    String emailAddress;

    @Test
    public void sendEstimationToEmail() {
        pricingCalculatorPage.openGeneratedEstimationPage();
        mainPage.closeCookiesPopUp();
        emailGeneratorPage.openEmailGeneratorPage();
        emailAddress = emailGeneratorPage.getEmailAddress();
        switchToTab("Google Cloud");
        pricingCalculatorPage.clickEmailEstimateBtn();
        pricingCalculatorPage.enterEmailAddress(emailAddress);
        pricingCalculatorPage.clickSendEmailBtn();
        switchToTab("Email Generator");
        fluentWait.until(ExpectedConditions.visibilityOf(emailGeneratorPage.getEstimatedCostFromEmail()));
        assertThat(emailGeneratorPage.getEstimatedCostFromEmail().getText(), CoreMatchers.containsString("Estimated Monthly Cost: USD 2,5"));
    }

    public void switchToTab(String title) {
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getTitle().contains(title)) {
                driver.switchTo().window(winHandle);
                break;
            }
        }
    }

}
