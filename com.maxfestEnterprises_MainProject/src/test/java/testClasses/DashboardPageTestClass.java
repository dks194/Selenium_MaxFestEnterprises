package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.UsersPage;

public class DashboardPageTestClass extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	UsersPage up;

	@Test(priority = 1)
	public void verifyUsersPageOpensWhileClickingOnThe_UserManagement() {

		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp=lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();
		String actual_heading = up.getHeadingOfUsersPage();
		
		Assert.assertTrue(actual_heading.contains("Users Manage users"));
	}

	@Test(priority = 2)
	public void verifyTheToolTipInTodaysProfitIcon() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp=lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.mouseHoverToTodaysProfitIcon();	
		String actual_toottip=dp.textInTodaysProfitToolTip();
		System.out.println(actual_toottip);
		
		Assert.assertEquals(actual_toottip, "Today's profit");
	}
}
