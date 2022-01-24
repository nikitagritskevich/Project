package automationTest.framework.utils;

import automationTest.framework.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudUtils {

  public static void fillingAllFieldsInPage(WebDriver driver){
    new GoogleCloudPage(driver)
        .openPage()
        .searchResult()
        .visitPagePricingCalculator()
        .sendNumberOfInstances("4")
        .enterSeriesNumber("n1")
        .enterMachineType("n1-standard-8")
        .addGPUs("GPU type", "Number of GPUs", "1")
        .selectLocalSSD()
        .selectCommittedUsages()
        .selectDataCenterLocation()
        .estimatePriceForPricing();
  }
}
