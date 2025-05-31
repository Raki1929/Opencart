package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import utilities.DataProviders;

public class LoginDDT extends baseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups = "Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		
		logger.info("***Starting Login DDT ***");
	try {
	//HomePage
	HomePage hp=new HomePage(driver); hp.clickMyAccount();
	hp.clickLogin();
	//Login
	loginPage lp=new loginPage(driver);
	lp.setEmail(email);
	lp.setPassword (pwd);
	lp. clickLogin();
	
	//MyAccount
	myAccountPage macc=new myAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	
	if (exp.equalsIgnoreCase("Valid"))
		if (targetPage == true) {
			macc.clickLogout();
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	if (exp.equalsIgnoreCase("Invalid")) {
		if (targetPage == true) {
			macc.clickLogout();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}
} catch (Exception e) {
	Assert.fail();
}

logger.info("***** Finish LoginDDT ******");

}
}

