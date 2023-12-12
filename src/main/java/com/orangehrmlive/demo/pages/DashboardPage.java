package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//img[@class='oxd-userdropdown-img'])[1]")
    WebElement profilePhoto;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
    WebElement logOut;

    @CacheLookup
    @FindBy(xpath = "(//h5[normalize-space()='Login'])[1]")
    WebElement loginPanel;

    public void clickOnProfilePhoto(){
        clickOnElement(profilePhoto);
        CustomListeners.test.log(Status.PASS,"Click on Profile");
    }
    public void clickOnLogOut(){
        clickOnElement(logOut);
        CustomListeners.test.log(Status.PASS,"Click on Logout");
    }

    public String getLoginPanel(){
        String message = getTextFromElement(loginPanel);
        CustomListeners.test.log(Status.PASS, "Verify Login panel");
        return message;
    }
}
