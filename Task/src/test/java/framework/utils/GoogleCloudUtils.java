package framework.utils;

import framework.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudUtils {

  public static void fillingAllFieldsInPage(WebDriver driver){
    new GoogleCloudPage(driver)
        .openPage()
        .searchResult()
        .visitPagePricingCalculator()
        .sendNumberOfInstances("4")
        .enterSeriesNumber("//md-option[@value='n1']")
        .enterMachineType("n1-standard-8")
        .addGPUs("GPU type", "Number of GPUs", "1")
        .selectLocalSSD("select_option_439")
        .selectCommittedUsages()
        .selectDataCenterLocation("select_option_236")
        .estimatePriceForPricing();
  }
}
