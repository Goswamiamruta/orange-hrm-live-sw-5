package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class UserTestWithDataProvider extends BaseTest {
    HomePage homePage;
    AdminPage adminPage;
    LoginPage loginPage;
    AddUserPage addUserPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        adminPage = new AdminPage();
        loginPage = new LoginPage();
     addUserPage = new AddUserPage();
    }


    @Test(dataProvider = "details", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String Status) {
        //Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        adminPage.clickOnAdmin();

        //Enter Username <username>
        //Select User Role <userRole>
        //Enter EmployeeName <employeeName>
        //Select Status <status>
       addUserPage.addDetails(username, userRole, employeeName, Status);

    }

}