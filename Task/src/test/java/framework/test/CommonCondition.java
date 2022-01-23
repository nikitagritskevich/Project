package framework.test;

import framework.driverManager.DriverManager;
import framework.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class CommonCondition {

  protected WebDriver driver;

  @BeforeMethod(description = "Opened Browser and made his  maximum size")
  public void initBrowser() {
    driver = DriverManager.getDriver();
  }

  @AfterMethod(alwaysRun = true, description = "Close Browser")
  public void closeBrowser() {
    DriverManager.closeDriver();
  }
}
