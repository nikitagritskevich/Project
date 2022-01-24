package automationTest.framework.page;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPricingCalculatorPage {

  private WebDriver driver;
  private WebDriverWait wait;
  private Logger logger = LogManager.getRootLogger();

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
    logger.info(String.format("Filing field with number of Instance: %s", numberInstances));
    return this;
  }

  public CloudPricingCalculatorPage enterSeriesNumber(String requireSeriesNumber) {
    seriesNumberComboBox.click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(
            By.xpath(String.format("//md-option[@value='%s']", requireSeriesNumber)))))
        .click();
    logger.info(String.format("Enter series number: %s", requireSeriesNumber));
    return this;
  }

  public CloudPricingCalculatorPage enterMachineType(String requireType) {
    wait.until(ExpectedConditions.visibilityOf(machineTypeComboBox)).click();
    wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath(String.format("//*[contains(text(),'%s')]", requireType)))).click();
    logger.info(String.format("Enter machine type: %s", requireType));
    return this;
  }

  public CloudPricingCalculatorPage addGPUs(String GPUType, String numberOfGPUElement,
      String numberOfGPU) {
    checkBoxAddGPU.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath(String.format("//md-select[@placeholder='%s']", GPUType)))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='NVIDIA_TESLA_V100']")))
        .click();
    driver.findElement(
            By.xpath(String.format("//md-select[@placeholder='%s']", numberOfGPUElement)))
        .sendKeys(numberOfGPU);
    logger.info(String.format("Add %s GPUs with type NVIDIA_TESLA_V100", numberOfGPU));
    return this;
  }

  public CloudPricingCalculatorPage selectLocalSSD() {
    localSSDListBox.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
            "//md-option[ancestor::div[@class='md-select-menu-container md-active md-clickable'] and @value='2']")))
        .click();
    logger.info("select local SSD");
    return this;
  }

  public CloudPricingCalculatorPage selectCommittedUsages() {
    committedUsagesListBox.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
            "//md-option[ancestor::div[@class='md-select-menu-container md-active md-clickable'] and @ng-value='1']")))
        .click();
    logger.info("select committed usages");
    return this;
  }

  public CloudPricingCalculatorPage selectDataCenterLocation() {
    dataCenterLocationComboBox.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
            "//*[ancestor::div[@class='md-select-menu-container cpc-region-select md-active md-clickable'] "
                + "and @value='europe-west3']")))
        .click();
    logger.info("select data center location");
    return this;
  }

  public CloudPricingCalculatorPage estimatePriceForPricing() {
    wait.until(ExpectedConditions.elementToBeClickable(estimatePriceButton)).click();
    logger.info("estimate pricing price");
    return this;
  }

  public PageGenerateRandomEmail sendToEmail() {
    wait.until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
    wait.until(ExpectedConditions.visibilityOf(emailTextFiled)).sendKeys(Keys.CONTROL + "v");
    sendEmailButton.click();
    logger.info("send to email price for pricing");
    return new PageGenerateRandomEmail(driver);
  }
}
