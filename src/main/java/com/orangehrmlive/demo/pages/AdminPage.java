package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]" )
    WebElement clickOnAdmin;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text-input'][normalize-space()='Admin']")
    WebElement selectAdmin;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-layout-context'])[1]" )
    WebElement verifyMessageSucecessFully;
    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
    WebElement searchButton;


    public void clickOnAdmin(){
        clickOnElement(clickOnAdmin);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void selectAdminFromDropDown(){
        selectByVisibleTextFromDropDown(selectAdmin,"Admin");
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public String verifySucessfulyMessage(){
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
        return getTextFromElement(verifyMessageSucecessFully);

    }
    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }
}
