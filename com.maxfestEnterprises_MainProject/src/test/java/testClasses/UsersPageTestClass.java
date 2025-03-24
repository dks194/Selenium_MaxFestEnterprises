package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.UsersPage;
import utilities.RandomAccessUtilities;

public class UsersPageTestClass extends BaseClass {
	LoginPage lp;
	DashboardPage dp;
	UsersPage up;

	@Test(priority = 0)
	public void verifyUserIsAdded() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		String randomfirstName = RandomAccessUtilities.getFirstName();
		String ranEmail = RandomAccessUtilities.getEmail();
		String ranPassword = RandomAccessUtilities.getpassword();
		up.AddUser(randomfirstName, ranEmail, ranPassword);
		String actual_text = up.searchEmailText();

		Assert.assertEquals(actual_text, ranEmail);
	}
	
	@Test(priority = 1)
	public void verifyErrorMessageAppearsifMandatoryField_firstName_IsNotProvided() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		String ranEmail = RandomAccessUtilities.getEmail();
		String ranPassword = RandomAccessUtilities.getpassword();
		up.mandatoryErrorInfirstname(ranEmail, ranPassword);
		
		String actual_errorMessage=up.firstNameErrorMessage();
		Assert.assertEquals(actual_errorMessage, "This field is required.");
		
	}
	
	@Test(priority = 2)
	public void verifyThe_IsActive_checkboxIsSelectedByDefault() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		up.clickOnAddButton();
		boolean actual_state = up.checkboxStatus();
		
		Assert.assertTrue(actual_state);	
	}
	
	@Test(priority = 3)
	public void verifyAConfirmationPopUpAppearsWhileDeletingAnUser() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		String randomfirstName = RandomAccessUtilities.getFirstName();
		String ranEmail = RandomAccessUtilities.getEmail();
		String ranPassword = RandomAccessUtilities.getpassword();
		up.AddUser(randomfirstName, ranEmail, ranPassword);
		
		up.clickOnDeleteButton();
		String actual_deletepopupText=up.deletePopupText();
		Assert.assertEquals(actual_deletepopupText, "Are you sure ?");
	}
	
	@Test(priority = 4)
	public void verifyThe_AddedUser_CanBeDeleted() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		String randomfirstName = RandomAccessUtilities.getFirstName();
		String ranEmail = RandomAccessUtilities.getEmail();
		String ranPassword = RandomAccessUtilities.getpassword();
		up.AddUser(randomfirstName, ranEmail, ranPassword);
		
		up.clickOnDeleteButton();
		up.clickOnDeleteButtonConfirmationPopup();
		
		String actual_message = up.messageAfterDeletingUser();
		Assert.assertEquals(actual_message, "No matching records found");			
	}
	
	@Test(priority = 5)
	public void verifyEditUserpageAppearsWhileClickingOnTheEditButton() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		String randomfirstName = RandomAccessUtilities.getFirstName();
		String ranEmail = RandomAccessUtilities.getEmail();
		String ranPassword = RandomAccessUtilities.getpassword();
		up.AddUser(randomfirstName, ranEmail, ranPassword);
		up.clickOnEditButton();
		Assert.assertEquals(up.getEditUserPageHeading(), "Edit user");
		
	}
	
	@Test(priority = 6)
	public void verifyThe_AddedUser_CanBeEdited() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		dp = lp.login("admin", "123456");
		dp.clickOnEndTourButton();
		dp.clickOnUsermanagement();
		up = dp.clickOnUsersTab();	
		
		String randomfirstName = RandomAccessUtilities.getFirstName();
		String ranEmail = RandomAccessUtilities.getEmail();
		String ranPassword = RandomAccessUtilities.getpassword();
		up.AddUser(randomfirstName, ranEmail, ranPassword);
		
		up.clickOnEditButton();
		
		
		String ranLastname = RandomAccessUtilities.getLastName();
		up.editlastName(ranLastname);
		String name = randomfirstName+" "+ranLastname;
		up.clickUpdateButton();
		up.searchUpdatedUser(name);
		
		String actual_updatedName = up.getUpdatedName();
		System.out.println(actual_updatedName);
		Assert.assertEquals(actual_updatedName, name);
	}
	
	
}
