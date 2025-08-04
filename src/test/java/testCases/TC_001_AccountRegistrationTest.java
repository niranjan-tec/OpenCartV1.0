package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(priority =1,retryAnalyzer = pageObjects.Retry.class )
	public void verify_account_registration() throws InterruptedException {

		logger.info("** Starting the test case  **");

		try {
			HomePage hp = new HomePage(driver);

			logger.info("** Click on my account link  **");
			hp.clickMyAccount();

			logger.info("** Click on my registration link  **");
			hp.clickRegister();

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("** Provide all customer details  **");
			regpage.setFirstName(ramdomeString().toUpperCase());
			regpage.setLastName(ramdomeString().toUpperCase());
			regpage.setEmail(ramdomeString() + "@gmail.com");
			regpage.setTelephone(ramdomeNumber());

			String password = ramdomeAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("** Validate expected message  **");
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		} catch (Exception e) {

			logger.info("** Test Failed  **");
			Assert.fail();
		}

	}

}
