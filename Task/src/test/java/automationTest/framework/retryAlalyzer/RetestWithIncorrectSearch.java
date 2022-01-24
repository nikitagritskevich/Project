package automationTest.framework.retryAlalyzer;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetestWithIncorrectSearch implements IRetryAnalyzer {

  private int count = 0;
  private int maxCount = 1;
  private final String exceptionRetry = "//a[parent::div[@class='gs-title'] and ./b[text() = 'Google Cloud Pricing Calculator']]";

  @Override
  public boolean retry(ITestResult iTestResult) {
    if (count < maxCount && iTestResult.getThrowable().getMessage().contains(exceptionRetry))
    {
      count++;
      return true;
    }
    return false;
  }
}
