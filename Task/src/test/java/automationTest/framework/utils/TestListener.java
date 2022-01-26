package automationTest.framework.utils;

import automationTest.framework.driverManager.DriverManager;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
private final Logger logger = LogManager.getRootLogger();

  @Override
  public void onTestStart(ITestResult iTestResult) {
logger.info("Test start");
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    logger.info("Test success");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot();
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    saveScreenshot();
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    logger.info("Test start");
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    logger.info("Test finish");
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
