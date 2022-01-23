package framework.utils;

import framework.driverManager.DriverManager;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  private Logger logger = LogManager.getRootLogger();

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot();
  }

  private void saveScreenshot() {
    File screenshotCapture = ((TakesScreenshot) (DriverManager.getDriver())).getScreenshotAs(
        OutputType.FILE);
    try {
      FileUtils.copyFile(screenshotCapture,
          new File(".//target//screenshots/" + getCurrentTimeAsString() + ".png"));
    } catch (IOException e) {
      logger.error("Error save screenshot ");
    }
  }

  public String getCurrentTimeAsString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
    return ZonedDateTime.now().format(format);
  }
}
