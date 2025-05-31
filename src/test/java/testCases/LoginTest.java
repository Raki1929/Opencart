package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.myAccountPage;
import pageObjects.loginPage;


public class LoginTest extends baseClass{
	
	

	@Test(groups = {"sanity", "master"})
	public void verify_login()
	{
	
	logger.info("****** Starting LoginTest *****");
	try
	{
	//HomePage
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount() ;
	hp.clickLogin();
	
	//Login
	loginPage lp=new loginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//MyAccount
	myAccountPage macc=new myAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	
	Assert.assertTrue(targetPage);
	}//Assert.assertEquals(targetPage, true, "Login failed");
	catch(Exception e)
	{
	Assert.fail();
}
	}
}
