package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class LoginTestWithDataProvider extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "credential", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String password, String errorMessage) {
        AddUserPage addUserPage;
        AdminPage adminPage;
        DashboardPage dashboardPage;
        HomePage homePage;
        LoginPage loginPage;
        ViewSystemUsersPage viewSystemUserPage;


    }    }