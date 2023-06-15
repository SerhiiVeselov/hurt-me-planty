package page;

import lombok.Getter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import util.Highlighter;
import java.util.ArrayList;

@Getter
public class PricingCalculatorPage extends AbstractPage {

    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
    ArrayList<String> openedTab = new ArrayList<>(driver.getWindowHandles());
    MainPage mainPage = new MainPage(driver);
    EmailGeneratorPage emailGeneratorPage = new EmailGeneratorPage(driver);
    private final Logger log = LogManager.getRootLogger();

    @FindBy(xpath = "//iframe[starts-with(@name,'goog_')]")
    private WebElement cloudSideFrame;

    @FindBy(id = "myFrame")
    private WebElement myFrame;

    @FindBy(id = "input_96")
    private WebElement numberOfInstancesField;

    @FindBy(css = "#select_value_label_88")
    private WebElement operatingSystemDrpDwn;

    @FindBy(id = "select_option_98")
    private WebElement debianOperatingSystem;

    @FindBy(css = "#select_value_label_89")
    private WebElement provisioningModelDrpDwn;

    @FindBy(id = "select_option_112")
    private WebElement spotProvisioningModel;

    @FindBy(css = "#select_value_label_92")
    private WebElement machineTypeDrpDwn;

    @FindBy(id = "select_option_452")
    private WebElement n1Standard8MachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGpuCheckBox;

    @FindBy(id = "select_488")
    private WebElement gpuTypeDrpDwn;

    @FindBy(id = "select_option_495")
    private WebElement nVidiaTeslaV100Gpu;

    @FindBy(id = "select_value_label_487")
    private WebElement numberOfGpuDrpDwn;

    @FindBy(id = "select_option_499")
    private WebElement gpuQuantity; //2

    @FindBy(id = "select_value_label_446")
    private WebElement localSsdDrpDwn;

    @FindBy(id = "select_option_473")
    private WebElement localSsdValue; //2x375 GB

    @FindBy(id = "select_value_label_94")
    private WebElement datacenterLocationDrpDwn;

    @FindBy(id = "select_option_254")
    private WebElement frankfurtDatacenterLocation;

    @FindBy(xpath = "//*[@id=\"mainForm\"]//div[21]/button")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//div[@class='cpc-cart-total']")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//div[contains(text(), 'Instance type')]")
    private WebElement instanceTypeOutput;

    @FindBy(xpath = "//div[contains(text(), 'Provisioning model')]")
    private WebElement provisioningModelOutput;

    @FindBy(xpath = "//div[contains(text(), 'Region')]")
    private WebElement regionOutput;

    @FindBy(xpath = "//div[contains(text(), 'Local SSD:')]")
    private WebElement localSsdOutput;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateBtn;

    @FindBy(id = "dialogContent_494")
    private WebElement emailEstimateTab;

    @FindBy(id = "input_479")
    private WebElement emailAddressField;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailBtn;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        log.info("Opening Google Cloud web page");
        driver.get("https://cloud.google.com/products/calculator");

    }

    public void enterNumberOfInstances(String numbOfInstances) {
        log.info("Entering number of Instances");
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cloudSideFrame));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((myFrame)));
        numberOfInstancesField.sendKeys(numbOfInstances);
    }

    public void selectOperatingSystem() {
        log.info("Selecting Operating System");
        operatingSystemDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(debianOperatingSystem));
        debianOperatingSystem.click();
    }

    public void selectProvisioningModel() {
        log.info("Selecting Provisioning Model");
        provisioningModelDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(spotProvisioningModel));
        spotProvisioningModel.click();
    }

    public void selectMachineType() {
        log.info("Selecting Machine Type");
        machineTypeDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(n1Standard8MachineType));
        n1Standard8MachineType.click();
    }

    public void checkAddGpuCheckBox() {
        log.info("Checking the Add GPU check box");
        addGpuCheckBox.click();
    }

    public void selectGpuType() {
        log.info("Selecting GPU type");
        gpuTypeDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(nVidiaTeslaV100Gpu));
        nVidiaTeslaV100Gpu.click();
    }

    public void selectGpuQuantity() {
        log.info("Selecting GPU quantity");
        numberOfGpuDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(gpuQuantity));
        gpuQuantity.click();
    }

    public void selectLocalSsd() {
        log.info("Selecting Local SSD");
        localSsdDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(localSsdValue));
        localSsdValue.click();
    }

    public void selectDatacenterLocation() {
        log.info("Selecting Datacenter location");
        datacenterLocationDrpDwn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(frankfurtDatacenterLocation));
        frankfurtDatacenterLocation.click();
    }

    public void addToEstimate() {
        log.info("Estimating the total cost based on the selected criteria");
        fluentWait.until(ExpectedConditions.elementToBeClickable(addToEstimateBtn));
        addToEstimateBtn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(totalEstimatedCost));
    }

    public void openGeneratedEstimationPage() {
        log.info("Opening previously estimated order");
        driver.get("https://cloud.google.com/products/calculator#id=2bb335fe-cd07-47d0-b714-081424f311cb");
    }

    public void clickEmailEstimateBtn() {
        log.info("Opening Send to Email tab");
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cloudSideFrame));
        fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((myFrame)));
        Highlighter.HighlightElement(driver, emailEstimateBtn);
        emailEstimateBtn.click();
        fluentWait.until(ExpectedConditions.visibilityOf(emailAddressField));
    }

    public void enterEmailAddress(String emailAddress) {
        log.info("Entering email address");
        Highlighter.HighlightElement(driver, emailAddressField);
        emailAddressField.click();
        emailAddressField.sendKeys(emailAddress);
    }

    public void clickSendEmailBtn() {
        log.info("Sending estimation to the entered email");
        Highlighter.HighlightElement(driver, sendEmailBtn);
        sendEmailBtn.click();
    }

    public void fillInputData() {
        log.info("Filling input data");
        enterNumberOfInstances("4");
        selectOperatingSystem();
        selectProvisioningModel();
        selectMachineType();
        checkAddGpuCheckBox();
        selectGpuType();
        selectGpuQuantity();
        selectLocalSsd();
        selectDatacenterLocation();
    }

}
