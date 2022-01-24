package automationTest.webDriver.bringItOn.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import automationTest.webDriver.bringItOn.page.PastebinHomePage;

public class WebDriverPastebinPageTest {

  private WebDriver driver;

  @BeforeClass(description = "Opened Browser and made his  maximum size")
  public void browserSetup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test(description = "Preparing for next Task")
  public void creationNewPaste() {
    new PastebinHomePage(driver).openPage().sendTextForPaste("Hello from WebDriver")
        .enterThePasteExpirationElements("10 Minutes")
        .sendNameTitlePaste("helloWeb");
    Assert.assertTrue(true);
  }

  @AfterClass(description = "Close Browser")
  public void closeBrowser() {
    driver.quit();
    driver = null;
  }
}
