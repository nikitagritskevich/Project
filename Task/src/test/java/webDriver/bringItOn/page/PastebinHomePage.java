package webDriver.bringItOn.page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.hurtMePlently.page.PageWithNewPaste;

public class PastebinHomePage extends AbstractPage {

  public PastebinHomePage(WebDriver driver) {
    super(driver);
  }


  public PastebinHomePage openPage() {
    driver.get(HOME_PAGE_URL);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return this;
  }

  public PastebinHomePage sendTextForPaste(String text) {
    textBoxForNewPaste.sendKeys(text);
    return this;
  }

  public PastebinHomePage enterThePasteExpirationElements(String expirationPasteElement) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(
        ExpectedConditions.elementToBeClickable(comboBoxPasteExpiration)).click();
    wait.until(
        ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath(String.format("//li[text()='%s']", expirationPasteElement))))).click();
    return this;
  }

  public PastebinHomePage sendNameTitlePaste(String title) {
    titlePaste.sendKeys(title);
    return this;
  }

  public PastebinHomePage enterTheSyntaxHighlightElement(String highlightElement) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(
        ExpectedConditions.visibilityOf(comboBoxSyntaxHighlight));
    wait.until(
        ExpectedConditions.elementToBeClickable(comboBoxSyntaxHighlight)).click();
    wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath(String.format("//li[text()='%s']",highlightElement)))).click();
    return this;
  }

  public PageWithNewPaste createNewPaste() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(
        ExpectedConditions.visibilityOf(createPasteButton));
    wait.until(
        ExpectedConditions.elementToBeClickable(createPasteButton)).submit();
    return new PageWithNewPaste(driver);
  }
}
