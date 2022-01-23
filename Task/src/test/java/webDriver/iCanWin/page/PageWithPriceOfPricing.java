package webDriver.iCanWin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageWithPriceOfPricing {

  @FindBy(xpath = "//md-list[@class='cartitem ng-scope']")
  private WebElement frameWithInformationOfPricing;

  public PageWithPriceOfPricing(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
  public String getFrameWithCloudPricingInformation(){
    return frameWithInformationOfPricing.getText();
  }
}
