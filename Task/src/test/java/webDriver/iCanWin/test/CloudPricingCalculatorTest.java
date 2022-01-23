package webDriver.iCanWin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webDriver.iCanWin.page.GoogleCloudPage;
import webDriver.iCanWin.page.PageWithPriceOfPricing;
import webDriver.iCanWin.page.RetestWithIncorrectSearch;

public class CloudPricingCalculatorTest {

  private WebDriver driver;

  @BeforeClass(description = "Opened Browser and made his  maximum size")
  private void openBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test(retryAnalyzer = RetestWithIncorrectSearch.class,
      description = "Test filling fields and selected required elements in combobox."
          + "And then checked correct filling data in page")
  public void calculatePricingAreNot() {
    new GoogleCloudPage(driver)
        .openPage()
        .searchResult()
        .visitPagePricingCalculator()
        .sendNumberOfInstances("4")
        .enterSeriesNumber("//md-option[@value='n1']")
        .enterMachineType("n1-standard-8")
        .addGPUs("GPU type", "Number of GPUs", "1")
        .selectLocalSSD("select_option_439")
        .selectCommittedUsages("//md-option[ancestor::div[@class='md-select-menu-container'] and @ng-value='1']")
        .selectDataCenterLocation("select_option_236")
        .estimatePriceForPricing();
    SoftAssert asserts = new SoftAssert();
    String pricingCloudInformation = new PageWithPriceOfPricing(
        driver).getFrameWithCloudPricingInformation();
    asserts.assertTrue(pricingCloudInformation.contains("Frankfurt"),
        "The region for Cloud pricing isn't equals");
    asserts.assertTrue(pricingCloudInformation.contains("1 Year"),
        "The commitment term isn't equals");
    asserts.assertTrue(pricingCloudInformation.contains("regular"), "The VM class isn't equals");
    asserts.assertTrue(pricingCloudInformation.contains("n1-standard-8"),
        "The instance type isn't equals");
    asserts.assertTrue(pricingCloudInformation.contains("2x375 GiB"),
        "The Local SSD isn't equals");
    asserts.assertAll();
  }

  @AfterClass(description = "Close Browser")
  private void closeBrowser() {
    driver.quit();
  }

}
