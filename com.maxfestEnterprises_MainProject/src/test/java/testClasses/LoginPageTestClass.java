package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.DataProviderClass;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ResetPasswordPage;

public class LoginPageTestClass extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	ResetPasswordPage rpp;

	@Test
	public void verifyTheExactPageIsOpenWhileHittingTheUrl() {
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.getTextOfLogin(), "Login");
	}

	@Test
	public void verifySuccessfulLogin() {
		lp = new LoginPage(driver);
		dp = lp.login("admin", "123456");
		Assert.assertEquals(dp.getTitleOfDashboardPage(), "Welcome Admin,");
	}
	
	@Test(dataProviderClass = DataProviderClass.class,dataProvider = "unsuccessfulLogin")
	public void verifyUnsuccessfulLogin(String username,String password) {
		lp = new LoginPage(driver);
		lp.login(username, password);
		String actual_message = lp.getTextOfErrorMesage();
		Assert.assertTrue(actual_message.contains("These credentials do not match our records."));
	}
	
	@Test
	public void verifyResetPasswordPageOpensWhileClickingOnThe_ForgotYourPassword_Link() {
		lp = new LoginPage(driver);
		rpp=lp.clickOnForgotPasswordLink();
		System.out.println(rpp.getTextOfResetPasswordPage());
		Assert.assertEquals(rpp.getTextOfResetPasswordPage(), "Reset Password");
	}
	
	
	
}
