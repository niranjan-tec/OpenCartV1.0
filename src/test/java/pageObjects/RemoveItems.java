package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RemoveItems extends BasePage {

	public RemoveItems(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	WebElement deskOption;

	@FindBy(xpath = "//a[normalize-space()='Mac (1)']")
	WebElement selectOptMac;

	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	WebElement btnAddToCart;

	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement btnCartTotal;

	@FindBy(xpath = "//button[@title='Remove']")
	WebElement remProduct;

	@FindBy(xpath = "//p[text()='Your shopping cart is empty!']")
	WebElement empText;

	public void VerifyAddAndRemoveProductFuctionality() throws InterruptedException {
		deskOption.click();
		selectOptMac.click();
		btnAddToCart.click();
		Thread.sleep(2000);
		btnCartTotal.click();
		Thread.sleep(2000);
		remProduct.click();
		Thread.sleep(2000);
		btnCartTotal.click();
		System.out.println("Message of empty cart :" + empText.getText());

	}

	public String verifyCartIsEmpty() {

		return empText.getText();
	}

}
