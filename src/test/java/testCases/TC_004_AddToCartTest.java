package testCases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_004_AddToCartTest extends BaseClass{
	
	
	
	@Test(priority =4 )
	public void login() {

		logger.info("** Start Login Test TC_002 **");

		try {
			
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			// Login Page
			logger.info("** Enter the login details**");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));			
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
		
			AddToCart atc= new AddToCart(driver);
			logger.info("** Add to cart **");
			atc.addMacProductInCart();
			
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("** Finished Login Test TC_002 **");
	}

}
