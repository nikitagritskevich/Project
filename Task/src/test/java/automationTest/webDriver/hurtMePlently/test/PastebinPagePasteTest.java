package automationTest.webDriver.hurtMePlently.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import automationTest.webDriver.hurtMePlently.page.PageWithNewPaste;
import automationTest.webDriver.bringItOn.page.PastebinHomePage;

public class PastebinPagePasteTest {

  private WebDriver driver;

  @BeforeClass(description = "Opened Browser and made his  maximum size")
  public void initBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test(description = "In test filling fields for paste and selected optional function for paste and checked paste create or not")
  public void createPasteAreNot() {
    PageWithNewPaste pageWithNewPaste = new PastebinHomePage(driver).openPage()
        .sendTextForPaste("git config --global user.name  \"New Sheriff in Town\"\n")
        .sendTextForPaste("git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n")
        .sendTextForPaste("git push origin master --force")
        .enterTheSyntaxHighlightElement("Bash")
        .enterThePasteExpirationElements("10 Minutes")
        .sendNameTitlePaste("how to gain dominance among developers")
        .createNewPaste();
    SoftAssert asserts = new SoftAssert();
    asserts.assertEquals(pageWithNewPaste.getSyntaxString(), "Bash",
        "The syntax in new Paste is incorrect");
    asserts.assertEquals(
        pageWithNewPaste.getPasteNameTitle(), "how to gain dominance among developers",
        "The name Title is incorrect");
    asserts.assertEquals(pageWithNewPaste.getTextBoxPaste()
        , ("git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force"), "The text paste is incorrect");
    asserts.assertAll();
  }

  @AfterClass(description = "Close Browser")
  public void closeBrowser() {
    driver.quit();
  }

}
