package automationTest.framework.test;

import automationTest.framework.page.MultiPageWithEmailAndPricingCloud;
import automationTest.framework.page.PageGenerateRandomEmail;
import automationTest.framework.utils.GoogleCloudUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloudPricingCalculatorTest extends CommonCondition {

  @Test(description = "Generating email and send to email result calculate cloud pricing and checked corrected price.")
  public void calculateCloudPricingAndSendPriceOnEmailOrNot() {
    GoogleCloudUtils.fillingAllFieldsInPage(driver);
    new PageGenerateRandomEmail(driver).openNewTab().generateRandomEmail().sendToEmail()
        .moveToTabWithEmail();
    MultiPageWithEmailAndPricingCloud pageEmailAndPricingCloud = new MultiPageWithEmailAndPricingCloud(
        driver);
    String valuePriceFromEmail = pageEmailAndPricingCloud.getPriceValueFromEmail();
    String valuePriceFromCloudPricing = pageEmailAndPricingCloud.getPriceValueFromCloudPricing();
    Assert.assertEquals(valuePriceFromEmail, valuePriceFromCloudPricing, "The price is mismatch");
  }



}
