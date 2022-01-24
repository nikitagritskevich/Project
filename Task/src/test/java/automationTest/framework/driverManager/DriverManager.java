package automationTest.framework.driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      switch (System.getProperty("browser")) {
        case "edge": {
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
          break;
        }
        case "chrome": {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          break;
        }
      }
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
