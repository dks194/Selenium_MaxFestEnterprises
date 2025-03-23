package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ResetPasswordPage;
import utilities.Constants;

public class LoginPageTestClass extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	ResetPasswordPage rpp;

	@Test(priority = 1,groups="Group1")
	public void verifyTheExactPageIsOpenWhileHittingTheUrl() {
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.getTextOfLogin(), Constants.headingOfLoginPage);
		//Assert.assertEquals(lp.getTextOfLogin(), "Login");
	}

	@Test(priority = 2)
	public void verifySuccessfulLogin() {
		lp = new LoginPage(driver);
		dp = lp.login(Constants.userName, Constants.password);
		String actual_Result = dp.getTitleOfDashboardPage();
		Assert.assertEquals(actual_Result, "Welcome Admin ,");
		System.out.println(actual_Result);
	}
	
	@Test(priority = 3, dataProviderClass = DataProviderClass.class,dataProvider = "unsuccessfulLogin")
	public void verifyUnsuccessfulLogin(String username,String password) {
		lp = new LoginPage(driver);
		lp.login(username, password);
		String actual_message = lp.getTextOfErrorMesage();
		Assert.assertTrue(actual_message.contains("These credentials do not match our records."));
	}
	
	@Test(priority = 4,groups="Group1")
	public void verifyResetPasswordPageOpensWhileClickingOnThe_ForgotYourPassword_Link() {
		lp = new LoginPage(driver);
		rpp=lp.clickOnForgotPasswordLink();
		System.out.println(rpp.getTextOfResetPasswordPage());
		Assert.assertEquals(rpp.getTextOfResetPasswordPage(), "Reset Password");
	}
	
	
	
}
