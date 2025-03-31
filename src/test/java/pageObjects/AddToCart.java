package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddToCart extends BasePage {
	
	
	public AddToCart(WebDriver driver){
		
		super(driver);
		
	}

	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	 WebElement deskOption;
	
	@FindBy(xpath="//a[normalize-space()='Mac (1)']")
	 WebElement selectOptMac;
	
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement btnCartTotal;
	
	//@FindBy(xpath = "//td[@class='text-left']//a[contains(text(),'iMac')]")
	//WebElement iMacName;
	
	@FindBy(xpath = "//strong[normalize-space()='Sub-Total']")
	WebElement iMacName;
	
	@FindBy(xpath = "//span[@id='cart-total']//i")
	WebElement txtItem;

	
	
	
	public void addMacProductInCart() throws InterruptedException {
		deskOption.click();
		selectOptMac.click();
		btnAddToCart.click();
		btnCartTotal.click();
		
		Thread.sleep(5000);
		
	}
	
	
	public boolean isSubToTextVisible() {
	
		try {
			return(iMacName.isDisplayed());
		}
		catch(Exception e) {
			
			return false;
			
		}
	}
	
	
	public String getTextVisible(String ss) {
		
		String tdt = txtItem.getText();
		
		return tdt;
	}
	
}
