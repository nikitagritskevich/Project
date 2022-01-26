package automationTest.framework.service;

import automationTest.framework.model.PricingData;
import automationTest.framework.page.CloudPricingCalculatorPage;
import automationTest.framework.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudService {

  public static void fillingFieldsForCalculatePricing(WebDriver driver) {
    PricingData pricingData = new PricingData();
    openGoogleCloudAndSearchPricingCloudPage(driver)
        .sendNumberOfInstances(pricingData.getNumberInstance())
        .enterSeriesNumber(pricingData.getSeriesNumber())
        .enterMachineType(pricingData.getMachineType())
        .addGPUs(pricingData.getModelCard(), pricingData.getNumberGPUs())
        .selectLocalSSD(pricingData.getLocalSSDValue())
        .selectCommittedUsages(pricingData.getCommittedUsages())
        .selectDataCenterLocation(pricingData.getValueDatacenterLocation())
        .estimatePriceForPricing();
  }

  public static CloudPricingCalculatorPage openGoogleCloudAndSearchPricingCloudPage(
      WebDriver driver) {
    return new GoogleCloudPage(driver)
        .openPage()
        .searchResult().visitPagePricingCalculator("Google Cloud Pricing Calculator");
  }
}
