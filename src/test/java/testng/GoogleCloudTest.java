package testng;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GoogleCloudTest extends CommonConditions {

    @Test(priority = 1)
    @Description("Opening Pricing Calculator")
    public void openPricingCalculator() {
        mainPage.openMainPage();
        fluentWait.until(ExpectedConditions.visibilityOf(mainPage.getCookiesOkBtn()));
        mainPage.closeCookiesPopUp();
        mainPage.openSearchField();
        mainPage.enterSearchRequest();
        fluentWait.until(ExpectedConditions.visibilityOf(mainPage.getSuggestSearchResult()));
        mainPage.clickSuggestSearchResult();
        fluentWait.until(ExpectedConditions.visibilityOf(searchResultsPage.getSearchResultsTab()));
        searchResultsPage.clickPricingCalculatorLink();
        assertEquals("https://cloud.google.com/products/calculator", driver.getCurrentUrl());
    }

    @Test(priority = 2)
    public void fillCalculationForm() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.fillInputData();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
    }

    @Test(priority = 3)
    public void verifyProvisioningModel() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.fillInputData();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Provisioning model: Spot", pricingCalculatorPage.getProvisioningModelOutput().getText());
    }

    @Test(priority = 4)
    public void verifyInstanceType() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.fillInputData();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Instance type: n1-standard-8", pricingCalculatorPage.getInstanceTypeOutput().getText());
    }

    @Test(priority = 5)
    public void verifyRegion() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.fillInputData();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Region: Frankfurt", pricingCalculatorPage.getRegionOutput().getText());
    }

    @Test(priority = 6)
    public void verifyLocalSsd() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.fillInputData();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Local SSD: 2x375 GiB", pricingCalculatorPage.getLocalSsdOutput().getText());
    }

    @Test(priority = 7)
    public void verifyCalculatedCost() {
        pricingCalculatorPage.openPage();
        mainPage.closeCookiesPopUp();
        pricingCalculatorPage.fillInputData();
        pricingCalculatorPage.addToEstimate();
        fluentWait.until(ExpectedConditions.visibilityOf(pricingCalculatorPage.getTotalEstimatedCost()));
        assertEquals("Total Estimated Cost: USD 2,575.41 per 1 month", pricingCalculatorPage.getTotalEstimatedCost().getText());
    }

}
