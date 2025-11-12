package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBases.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{


	@Test(groups= {"Sanity","Regression","Master"})


	public void verify_account_registration()
	{
		logger.info("****TC001_AccountRegistrationTest*****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

	AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

	logger.info("Providing customer details.....");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());

		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);


		regpage.setPrivacyPolicy();
		regpage.clickContinue();

		logger.info("validating expected message");
		String confmsg = regpage.getConfirmationMsg();

		Assert.assertEquals(confmsg, "Your Account Has Been Created!");


	}
	public String randomAlphaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
	return (generatedstring+"@"+generatednumber);
	}
}
