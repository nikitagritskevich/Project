package framework.page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.iCanWin.page.CloudPricingCalculatorPage;

public class PageGenerateRandomEmail {

  private WebDriver driver;
  private List<String> availableTabs;

  @FindBy(xpath = "//a[@title='Случайный одноразовый адрес электронной почты']")
  private WebElement generateRandomEmailButton;

  @FindBy(id = "refresh")
  private WebElement refreshEmailButton;

  public PageGenerateRandomEmail(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public PageGenerateRandomEmail openNewTab() {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("window.open('https://yopmail.com/')");
    availableTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(availableTabs.get(1));
    return this;
  }

  public CloudPricingCalculatorPage generateRandomEmail() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
        ExpectedConditions.elementToBeClickable(generateRandomEmailButton)).click();
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
        ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cprnd")))).click();
    driver.switchTo().window(availableTabs.get(0));
    return new CloudPricingCalculatorPage(driver);
  }

  public void moveToTabWithEmail() {
    List<String> availableTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(availableTabs.get(1));
    new WebDriverWait(driver, Duration.ofSeconds(1)).until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='egengo();']")))
        .click();
    while (!driver.findElement(By.id("nbmail")).getText().contains("1")) {
      refreshEmailButton.click();
    }
  }
}
