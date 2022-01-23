package webDriver.iCanWin.page;

import java.time.Duration;
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

  @FindBy(xpath = "//div[@class='devsite-search-container']")
  private WebElement searchButton;

  @FindBy(xpath = "//input[@aria-label='Search']")
  private WebElement searchTextField;

  public GoogleCloudPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public GoogleCloudPage openPage() {
    driver.get("https://cloud.google.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    return new CloudPricingCalculatorPage(driver);
  }
}
