package framework.page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiPageWithEmailAndPricingCloud {

  private WebDriver driver;

  @FindBy(xpath = "//h3[parent::td[not(@colspan ='3')]]")
  private WebElement valuePriceEmail;

  @FindBy(xpath = "//b[ parent::h2 and@class='ng-binding']")
  private WebElement valuePriceGoogleCloud;

  @FindBy(xpath = "//iframe[parent::devsite-iframe]")
  private WebElement devsiteIframe;

  @FindBy(id = "myFrame")
  private WebElement iframeElement;

  public MultiPageWithEmailAndPricingCloud(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getPriceValueFromEmail() {

    driver.switchTo().frame(driver.findElement(By.id("ifmail")));
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
        ExpectedConditions.visibilityOf(valuePriceEmail)).getText();
  }

  public String getPriceValueFromCloudPricing() {
    List<String> handles = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(handles.get(0));
    driver.switchTo().frame(devsiteIframe);
    driver.switchTo().frame(iframeElement);
    int beginIndexToUSd = valuePriceGoogleCloud.getText().indexOf("USD");
    int endIndexToPer = valuePriceGoogleCloud.getText().indexOf(" per");
    return valuePriceGoogleCloud.getText().substring(beginIndexToUSd, endIndexToPer);
  }

}
