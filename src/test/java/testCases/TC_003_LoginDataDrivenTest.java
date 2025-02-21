package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*
 * Data is valid - Login success -test pass -logout 
 * 
 * login failed -test fail
 * 
 * Data is invalid - Login success - test fail -logout 
 * login failed - test pass
 * 
 */
public class TC_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // Getting data provider from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		logger.info("** Starting TC_003_LoginDataDrivenTesting **");
		
		try {
		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// Login Page
		logger.info("** Enter the login details**");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		// My Account Page
		logger.info("** Validate the my account text **");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();

		/*
		 * Data is valid - Login success -test pass -logout 
		 * 
		 * login failed -test fail
		 * 
		 * Data is invalid - Login success - test fail -logout 
		 * login failed - test pass
		 * 
		 */

		if (exp.equalsIgnoreCase("Valid")) {

			if (targetPage == true) {

				macc.clickLogout();
				Assert.assertTrue(true);

			} else {

				Assert.assertFalse(false);
			}

		}

		if (exp.equalsIgnoreCase("Invalid")) {

			if (targetPage == true) {

				macc.clickLogout();
				Assert.assertTrue(false);

			} else {

				Assert.assertFalse(true);
			}
		}
		
		}
		catch(Exception e){
			
			Assert.fail();
		}
		
		logger.info("** Finished TC_003_LoginDataDrivenTesting **");
	}
	
	
}
