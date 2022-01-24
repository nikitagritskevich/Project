package automationTest.framework.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGenerateRandomEmail {

  private WebDriver driver;
  private List<String> availableTabs;
  private Logger logger = LogManager.getRootLogger();
  private final String HTML_URL = "https://yopmail.com/";
  @FindBy(xpath = "//a[parent::div[@id='listeliens'] and @href='email-generator']")
  private WebElement generateRandomEmailButton;

  @FindBy(id = "refresh")
  private WebElement refreshEmailButton;

  public PageGenerateRandomEmail(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public PageGenerateRandomEmail openNewTab() {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript(String.format("window.open('%s')",HTML_URL));
    availableTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(availableTabs.get(1));
    logger.info(String.format("open %s page",HTML_URL));
    return this;
  }

  public CloudPricingCalculatorPage generateRandomEmail() {
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(generateRandomEmailButton)).click();
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cprnd")))).click();
    logger.info("Generate random email,save name email in clipboard and switch to google cloud page");
    driver.switchTo().window(availableTabs.get(0));
    return new CloudPricingCalculatorPage(driver);
  }
  public void moveToTabWithEmail() {
    List<String> availableTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(availableTabs.get(1));
    new WebDriverWait(driver, 10).until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='egengo();']")))
        .click();
    for (int i = 0; i < 3 || !driver.findElement(By.id("nbmail")).getText().contains("1"); i++) {
      try {
        TimeUnit.MILLISECONDS.sleep(400);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      refreshEmailButton.click();
    }
    logger.info("switch to email page and checking emailBox with price");
  }
}
