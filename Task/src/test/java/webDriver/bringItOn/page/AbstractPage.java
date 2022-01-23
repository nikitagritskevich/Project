package webDriver.bringItOn.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
  protected static final String HOME_PAGE_URL = "https://pastebin.com";
  protected WebDriver driver;

  @FindBy(id = "postform-text")
  protected WebElement textBoxForNewPaste;

  @FindBy(xpath = "//*[@aria-labelledby='select2-postform-expiration-container']")
  protected WebElement comboBoxPasteExpiration;

  @FindBy(xpath = "//input[@name='PostForm[name]']")
  protected WebElement titlePaste;

  @FindBy(xpath = "//*[@aria-labelledby='select2-postform-format-container']")
  protected  WebElement comboBoxSyntaxHighlight;

  @FindBy(xpath = "//button[@type='submit']")
  protected WebElement createPasteButton;

  public AbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
  }

}
