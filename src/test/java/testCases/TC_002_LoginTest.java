package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	
	@Test(priority =2 )
	public void verify_login() {

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

			// My Account Page
			logger.info("** Validate the my account text **");
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			Assert.assertTrue(targetPage);//	Assert.assertEquals(targetPage, true, "Login Failed");
			
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("** Finished Login Test TC_002 **");
	}

}
