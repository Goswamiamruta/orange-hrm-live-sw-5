package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @Test(groups = {"sanity", "smoke", "regression" })
    public void verifyUserShouldLoginSuccessFully() {
        //1.1Enter username
        homePage.enterUserName("Admin");
        //1.2Enter password
        homePage.enterPassWord("admin123");
        //1.3Click on Login Button
        loginPage.setClickOnLogin();
        //Verify "WelCome" Message

    }

    @Test(groups = {"smoke", "regression" })
    public void verifyThatTheLogoDisplayOnHomePage() {
        //2.1Login To The application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //2.2 Verify Logo is Displayed
        homePage.displayLogoHome();
    }

    @Test(groups = {"regression" })
    public void verifyUserShouldLogOutSuccessFully() {


        //3.1Login To The application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //3.2 Click on User Profile logo
        dashboardPage.clickOnProfilePhoto();
        //3.3 Mouse hover on "Logout" and click
        dashboardPage.clickOnLogOut();
        //3.4 Verify the text "Login Panel" is displayed
        String actualText = dashboardPage.getLoginPanel();
        Assert.assertEquals(actualText, "Login");
    }

    @Test(groups = {"regression" })
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();

        //4.1Enter username <username>
        homePage.enterUserName("Admin");
        //4.2Enter password <password>
        homePage.enterPassWord("admin123");
        //4.3Click on Login Button
        loginPage.setClickOnLogin();
        //4.4Verify Error message <errorMessage>
        String actualText = homePage.getErrorMessage();
        Assert.assertEquals(actualText, "Error message");


    }
}