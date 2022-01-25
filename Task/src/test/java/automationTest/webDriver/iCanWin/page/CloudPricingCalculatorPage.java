package automationTest.webDriver.iCanWin.page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPricingCalculatorPage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
  private WebElement numberOfInstancesTextField;

  @FindBy(xpath = "//md-select-value[parent::md-select[@placeholder=\"Series\"]]")
  private WebElement seriesNumberComboBox;

  @FindBy(xpath = "//md-select-value[parent::md-select[@placeholder='Instance type']]")
  private WebElement machineTypeComboBox;

  @FindBy(xpath = "//iframe[parent::devsite-iframe]")
  private WebElement devsiteIframe;

  @FindBy(id = "myFrame")
  private WebElement iframeElement;

  @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
  private WebElement checkBoxAddGPU;

  @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
  private WebElement localSSDListBox;

  @FindBy(xpath = "//md-select-value[parent::md-select[@ng-model='listingCtrl.computeServer.cud']]")
  private WebElement committedUsagesListBox;

  @FindBy(xpath = "//md-select-value[parent::md-select[@ng-model='listingCtrl.computeServer.location']]")
  private WebElement dataCenterLocationComboBox;

  @FindBy(xpath = "//*[@aria-label='Add to Estimate' and (not (@disabled='disabled'))]")
  private WebElement estimatePriceButton;

  @FindBy(xpath = "//button[@aria-label='Email Estimate']")
  private WebElement emailEstimateButton;

  @FindBy(xpath = "//*[@type='email']")
  private WebElement emailTextFiled;

  @FindBy(xpath = "//button[@aria-label='Send Email']")
  private WebElement sendEmailButton;

  public CloudPricingCalculatorPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.switchTo().frame(devsiteIframe);
    driver.switchTo().frame(iframeElement);
  }

  public CloudPricingCalculatorPage sendNumberOfInstances(String numberInstances) {
    wait.until(ExpectedConditions.visibilityOf(numberOfInstancesTextField));
    numberOfInstancesTextField.sendKeys(numberInstances);
    return this;
  }

  public CloudPricingCalculatorPage enterSeriesNumber(String requireSeriesNumber) {
    seriesNumberComboBox.click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(requireSeriesNumber))))
        .click();
    return this;
  }

  public CloudPricingCalculatorPage enterMachineType(String requireType) {
    wait.until(ExpectedConditions.visibilityOf(machineTypeComboBox)).click();
    wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath(String.format("//*[contains(text(),'%s')]", requireType)))).click();
    return this;
  }

  public CloudPricingCalculatorPage addGPUs(String GPUType, String numberOfGPUElement,
      String numberOfGPU) {
    checkBoxAddGPU.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath(String.format("//md-select[@placeholder='%s']", GPUType)))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("select_option_458"))).click();
    driver.findElement(
            By.xpath(String.format("//md-select[@placeholder='%s']", numberOfGPUElement)))
        .sendKeys(numberOfGPU);
    return this;
  }

  public CloudPricingCalculatorPage selectLocalSSD(String numberLocalSSD) {
    localSSDListBox.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id(numberLocalSSD))).click();
    return this;
  }

  public CloudPricingCalculatorPage selectCommittedUsages(String committedUsagesType) {
    committedUsagesListBox.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(committedUsagesType))).click();
    return this;
  }

  public CloudPricingCalculatorPage selectDataCenterLocation(String locationElement) {
    dataCenterLocationComboBox.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id(locationElement))).click();
    return this;
  }

  public CloudPricingCalculatorPage estimatePriceForPricing() {
    wait.until(ExpectedConditions.elementToBeClickable(estimatePriceButton)).click();
    return this;
  }

}
