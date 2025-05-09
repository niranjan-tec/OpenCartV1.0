package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GetAppleCinemaFeature;
import testBase.BaseClass;

public class TC_006_verifyAppleCinemaFeatureTest extends BaseClass {

	@Test(priority = 6)

	public void getAppleCinemaFeature() {

		try {

			logger.info("Click on the drop down and select the product : ");

			GetAppleCinemaFeature appCineFeature = new GetAppleCinemaFeature(driver);

			logger.info("Click on the Apple Cine Product and Get the featured details : ");
			appCineFeature.verifyAppleCinemaFeature();
			logger.info("Verify the feature is visible or not   : ");
			Assert.assertEquals(appCineFeature.isFeaturesVisible(), true);
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
