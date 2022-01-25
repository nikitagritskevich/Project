package automationTest.webDriver.hardcore.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGenerateRandomEmail {

  private final WebDriver driver;
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

}
