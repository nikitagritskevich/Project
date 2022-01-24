package automationTest.webDriver.hurtMePlently.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageWithNewPaste {

  private final WebDriver driver;

  @FindBy(xpath = "//div[@class='info-top']")
  private WebElement pasteNameTitle;

  @FindBy(xpath = "//div[@class='left']/a")
  private WebElement enterTheSyntax;

  @FindBy(xpath = "//ol[@class='bash']")
  private WebElement textBoxPaste;

  public PageWithNewPaste(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getSyntaxString() {
    return enterTheSyntax.getText();
  }

  public String getPasteNameTitle() {
    return pasteNameTitle.getText();
  }

  public String getTextBoxPaste() {
    return textBoxPaste.getText();
  }

}