package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddToCart extends BasePage {

	public AddToCart(WebDriver driver) {

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

	@FindBy(xpath = "//div[text()=' Success: You have added ']")
	WebElement prodAddedConfirmationMess;

	public void addMacProductInCart() throws InterruptedException {
		deskOption.click();
		selectOptMac.click();
		btnAddToCart.click();

		System.out.println("Confirmation Message : " + prodAddedConfirmationMess.getText());

	}

	public boolean isAddToCardConfirmationMessageDisplayed() {

		return prodAddedConfirmationMess.isDisplayed();
	}

}
