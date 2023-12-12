package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    ViewSystemUsersPage viewSystemUsersPage;
    LoginPage loginPage;


    @BeforeMethod
    public void inIt() {
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        loginPage =new LoginPage();


    }

    @Test(groups = {"sanity", "smoke", "regession" })
    public void adminShouldAddUserSuccessFully() {
        //1.1 Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();

        //1.2 click On "Admin" Tab
        adminPage.clickOnAdmin();
        //1.3 Verify "System Users" Text
        String actualText = viewSystemUsersPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //1.4 click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //1.5 Verify "Add User" Text
        String actualMessage = addUserPage.setVerifyAddUserText();
        String expectedMessage = "Add User";
        Assert.assertEquals(actualMessage, expectedMessage, "Add User is not displayed");
        //	click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //1.6 Select User Role "Admin"
        adminPage.selectAdminFromDropDown();
        //1.7 enter Employee Name "Ananya Dash"
        addUserPage.setEnterEmployeeName("Ananya Dash");
        //1.8 enter Username
       addUserPage.setEnterTheUserName("Ananya Dash");
        //1.9 Select status "Disable"
        addUserPage.setSelectDisable();
        //1.10 enter psaaword
        homePage.enterPassWord("admin123");
        //1.11 enter Confirm Password
        addUserPage.setConfirmPassword("admin123");
        //1.12 click On "Save" Button
        addUserPage.setClickOnSaveButton();
        //1.13 verify message "Successfully Saved"
        String actualMessage1 = adminPage.verifySucessfulyMessage();
        String expectedMessage1 = "Successfully Saved";
        Assert.assertEquals(actualMessage1, expectedMessage1, "Successfully Saved is not displayed");


    }
    @Test(groups = {"sanity", "smoke" })
    public void searchTheUserCreatedAndVerifyIt() {
        //2.1Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //2.2click On "Admin" Tab
        adminPage.clickOnAdmin();

        //2.3Verify "System Users" Text
        String actualText = viewSystemUsersPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");


        //2.4Enter Username
        addUserPage.setEnterTheUserName("Amruta");
        //2.5Select User Role
        addUserPage.setUserRoleSelect("Admin");
        //2.6Select Satatus
        addUserPage.selectStatusEnable("Disable");
        //2.7Click on "Search" Button
        addUserPage.clickOnSearchButton();
        //2.8Verify the User should be in Result list.
        String actualResult = addUserPage.setVerifyTheResult();
        String expectedResult = "Virat kholi";
        Assert.assertEquals(actualResult, expectedResult, "Virat Kholi is not displayed");
    }
    @Test(groups = {"regession" })
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        //3.1 Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //3.2 click On "Admin" Tab
        adminPage.clickOnAdmin();
        //3.3 Verify "System Users" Text
        String actualText = viewSystemUsersPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //3.4 Enter Username
        homePage.enterPassWord("admin123");
        //3.5 Select User Role
        addUserPage.setUserRoleSelect("Admin");
        //3.6 Select Satatus
        addUserPage.selectStatusEnable("Disable");
        //Click on "Search" Button
        addUserPage.clickOnSearchButton();

        //Verify the User should be in Result list.
        String actualResult = addUserPage.setVerifyTheResult();
        String expectedResult = "Virat kholi";
        Assert.assertEquals(actualResult, expectedResult, "Virat Kholi is not displayed");
        //Click on Check box
        addUserPage.setTickOnCheckbox();
        //Click on Delete Button
        addUserPage.setClickOnDeleteButton();

        //Popup will display
        addUserPage.verifyThePopUpWindowIsDisplayed();
        //Click on Ok Button on Popup
       addUserPage.clickOnYesButton();
        //verify message "Successfully Deleted"

    }
    @Test(groups = {"regession" })
    public void searchTheUserAndVerifyTheMessageRecordFound() {
        //Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //click On "Admin" Tab
        adminPage.clickOnAdmin();
        //Verify "System Users" Text
        String actualText = viewSystemUsersPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //Enter Username <username>
        homePage.enterPassWord("admin123");
        //Select User Role <userRole>
        addUserPage.setUserRoleSelect("Admin");
        //Enter EmployeeName <employeeName>
        addUserPage.setEnterEmployeeName("Ananya Dash");
        //Select Satatus <status>
        addUserPage.selectStatusEnable("Disable");
        //Click on "Search" Button verify message "(1) Record Found"

        //Verify username <username>

        //Click on Reset Tab



    }
}