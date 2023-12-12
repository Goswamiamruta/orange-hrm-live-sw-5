package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(name="username")
    WebElement userName;
    @CacheLookup
    @FindBy(name="password")
    WebElement passWard;
    @CacheLookup
    @FindBy(xpath= "//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']")
    WebElement hrmLogo;
    @CacheLookup
    @FindBy(xpath= "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement verifyLoginPanel;
    @CacheLookup
    @FindBy(xpath ="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]" )
    WebElement displayLogo;
    @CacheLookup
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")
    WebElement errorMessage;

    public void enterUserName(String value){
        sendTextToElement(userName,value);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void enterPassWord(String  value){
        sendTextToElement(passWard, value);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public String verifyLogin(){
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
        return getTextFromElement(verifyLoginPanel);

    }
    public void hrmLogo(){
        driver.findElement((By) hrmLogo).isDisplayed();
        CustomListeners.test.log(Status.PASS, "Message is not displayed");


    }
    public String displayLogoHome() {
        return getTextFromElement(displayLogo);
    }
    public String getErrorMessage() {
        return getTextFromElement(errorMessage);

    }
    public void EnterDetails(){


    }
}
