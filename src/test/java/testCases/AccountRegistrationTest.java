package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class AccountRegistrationTest extends baseClass {

	

	@Test(groups={"Regression", "master"})
	public void verify_account_registration() {
		
		logger.info("**** Starting AccountRegistrationTest ");
		try {
			
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link ");
		hp.clickRegister();
		logger.info("Clicked on Register Link ");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated regpage. setTelephone(randomeNumber ());
		String password=randomeAlphaNumberic();
		regpage.setPassword (password); regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug(" Debug logs");
			AssertJUnit.fail();
		}
	
	
}
}
