package webDriver.hardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webDriver.hardcore.page.PageGenerateRandomEmail;
import webDriver.iCanWin.page.GoogleCloudPage;
import webDriver.iCanWin.page.MultiPageWithEmailAndPricingCloud;
import webDriver.iCanWin.page.RetestWithIncorrectSearch;

public class CloudPricingCalculatorTest {

  private WebDriver driver;

  @BeforeClass(description = "Opened Browser and made his  maximum size")
  private void initBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test(retryAnalyzer = RetestWithIncorrectSearch.class, description =
      "Generating email and send to email result calculate cloud pricing."
          + "And checking on correct sent price in email and in google page")
  public void calculateCloudPricingAndSendPriceOnEmailOrNot() {
    openPageCloudPricingAndFillInAllFiled();
    new PageGenerateRandomEmail(driver).openNewTab().generateRandomEmail().sendToEmail()
        .moveToTabWithEmail();
    new MultiPageWithEmailAndPricingCloud(driver);
    MultiPageWithEmailAndPricingCloud pageEmailAndPricingCloud = new MultiPageWithEmailAndPricingCloud(
        driver);
    String valuePriceFromEmail = pageEmailAndPricingCloud.getPriceValueFromEmail();
    String valuePriceFromCloudPricing = pageEmailAndPricingCloud.getPriceValueFromCloudPricing();
    Assert.assertEquals(valuePriceFromEmail, valuePriceFromCloudPricing, "The price is mismatch");
  }

  private void openPageCloudPricingAndFillInAllFiled() {
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
  }


  @AfterClass(description = "Close Browser")
  private void closeBrowser() {
    driver.quit();
  }
}
