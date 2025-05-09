package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RemoveItems;
import testBase.BaseClass;

public class TC_005_RemoveItemsTest extends BaseClass{

	@Test(priority =5 )
	public void login() {

		logger.info("** Start Remove Items Test TC_005 **");

		try {
			
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			// Login Page
			logger.info("** Enter the login details **");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));			
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
		
			RemoveItems remProdut= new RemoveItems(driver);
			remProdut.VerifyAddAndRemoveProductFuctionality();
			logger.info("** Add item into cart and removed it **");
			Assert.assertEquals(remProdut.verifyCartIsEmpty(), "Your shopping cart is empty!");

			
		} catch (Exception e) {
			
			Assert.fail();
			
		}

		logger.info("** Finished The Remove Items Test TC_005 **");
	}

}
