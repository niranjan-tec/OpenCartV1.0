package pageObjects;

import org.apache.logging.log4j.spi.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import freemarker.log.Logger;

public class GetAppleCinemaFeature extends BasePage {

	public GetAppleCinemaFeature(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@class='dropdown']/a[text()='Components']")
	WebElement comptDropDowb;

	@FindBy(xpath = "//a[normalize-space()='Monitors (2)']")
	WebElement clkMonitorOpt;

	@FindBy(xpath = "//a[normalize-space()='Apple Cinema 30\"']")
	WebElement clkAppleCinemaProduct;

	@FindBy(xpath = "//h3[normalize-space()='Features:']")
	WebElement clkFeatures;
	
	@FindBy(xpath = "//div[@class='tab-content']//ul[1]")
	WebElement featureText;

	public void verifyAppleCinemaFeature() throws InterruptedException {

      
		comptDropDowb.click();
		clkMonitorOpt.click();

		BasePage pg = new BasePage(driver);

		pg.scrollToElement(clkAppleCinemaProduct);

		clkAppleCinemaProduct.click();
	
		pg.scrollToElement(clkFeatures);
	
		System.out.println("All the feature details:  "+featureText.getText());
	}
    
	public boolean isFeaturesVisible() {
		
	     return  clkFeatures.isDisplayed();
	}
	
	
}
