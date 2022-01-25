package automationTest.webDriver.hardcore.test;

import automationTest.framework.page.MultiPageWithEmailAndPricingCloud;
import automationTest.framework.page.PageGenerateRandomEmail;
import automationTest.framework.service.GoogleCloudService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloudPricingCalculatorTest  {

  private WebDriver driver;

  @BeforeClass()
  public void initBrowser(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test(description = "Generating email and send to email result calculate cloud pricing and checked corrected price.")
  public void calculateCloudPricingAndSendPriceOnEmailOrNot() {
    GoogleCloudService.fillingFieldsForCalculatePricing(driver);
    new PageGenerateRandomEmail(driver).openNewTab().generateRandomEmail().sendToEmail()
        .moveToTabWithEmail();
    MultiPageWithEmailAndPricingCloud pageEmailAndPricingCloud = new MultiPageWithEmailAndPricingCloud(
        driver);
    String valuePriceFromEmail = pageEmailAndPricingCloud.getPriceValueFromEmail();
    String valuePriceFromCloudPricing = pageEmailAndPricingCloud.getPriceValueFromCloudPricing();
    Assert.assertEquals(valuePriceFromEmail, valuePriceFromCloudPricing, "The price is mismatch");
  }

@AfterClass(alwaysRun = true)
  public void closeBrowser(){
    driver.quit();
  }

}
