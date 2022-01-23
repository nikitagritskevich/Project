package webDriver.hurtMePlently.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

  public boolean isNewPasteCreated() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(
        ExpectedConditions.visibilityOf(textBoxPaste));
    return pasteNameTitle.getText()
        .equals("how to gain dominance among developers") && textBoxPaste.getText()
        .equals("git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force");
  }
}