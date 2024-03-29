package automationTest.webDriver.iCanWin.page;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetestWithIncorrectSearch implements IRetryAnalyzer {

  private int count = 0;
  private final int maxCount = 3;

  @Override
  public boolean retry(ITestResult iTestResult) {
    iTestResult.getThrowable().getMessage();
    if (count < maxCount) {
      count++;
      return true;
    }
    return false;
  }
}
