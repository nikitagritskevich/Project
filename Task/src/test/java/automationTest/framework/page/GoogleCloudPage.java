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

public class GoogleCloudPage {

  private WebDriver driver;
  private WebDriverWait wait;
  private Logger logger = LogManager.getRootLogger();
  private final String HTML_URL = "https://cloud.google.com/";

  @FindBy(xpath = "//div[@class='devsite-search-container']")
  private WebElement searchButton;

  @FindBy(xpath = "//input[@aria-label='Search']")
  private WebElement searchTextField;

  public GoogleCloudPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
    PageFactory.initElements(driver, this);
  }

  public GoogleCloudPage openPage() {
    driver.get(HTML_URL);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    logger.info(String.format("The page %s open",HTML_URL));
    return this;
  }

  public GoogleCloudPage searchResult() {
    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    wait.until(ExpectedConditions.visibilityOf(searchTextField));
    searchTextField.sendKeys("Google Cloud Platform Pricing Calculator");
    searchTextField.sendKeys(Keys.ENTER);
    return this;
  }

  public CloudPricingCalculatorPage visitPagePricingCalculator() {
    By.xpath("//*[parent::md-input-container and ./md-checkbox[@tabindex='0']]");
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//a[parent::div[@class='gs-title'] and ./b[text() = 'Google Cloud Pricing Calculator']]"))).click();
    logger.info("Visit page google cloud pricing calculator");
    return new CloudPricingCalculatorPage(driver);
  }
}
