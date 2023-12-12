package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']" )
    static WebElement verifyAddUserText;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']" )
    WebElement enterEmployeeName;
    @CacheLookup
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']" )
    WebElement enterTheUserName;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Disabled')]")
    WebElement selectDisable;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//font[contains(text(),'Save')]")
    WebElement clickOnSaveButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div/div[2]/div/div/div[2]/i")
    WebElement userRoleSelect;
    @CacheLookup
    @FindBy(xpath="//*[@class='oxd-select-wrapper']//*[contains(text(),'Enabled')]")
    WebElement selectEnable;
    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
    WebElement searchButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Cheeku123')]")
    WebElement  verifyTheResult;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement   tickOnCheckbox ;
    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement   clickOnDeleteButton;
    @CacheLookup
    @FindBy(xpath = ("(//div[@role='document'])[1]"))
    WebElement popUpWindow;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Yes, Delete']"))
    WebElement yesButton;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Reset']"))
    WebElement reSetButton;
    @CacheLookup
    @FindBy(xpath = ("//label[normalize-space()='Username']"))
    WebElement verifyUsername;
    @CacheLookup
    @FindBy(xpath = ("//span[normalize-space()='No Records Found']"))
    WebElement noRecordFound;




    public String setVerifyAddUserText() {
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
        return getTextFromElement(verifyAddUserText);
    }
    public void setEnterEmployeeName(String employeeName){
        sendTextToElement(enterEmployeeName, employeeName);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setEnterTheUserName(String userName){
        sendTextToElement(enterTheUserName,userName);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setSelectDisable(){
        selectByIndexFromDropDown(selectDisable,0);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setConfirmPassword(String password){
        sendTextToElement(confirmPassword,password);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setClickOnSaveButton(){
        clickOnElement(clickOnSaveButton);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setUserRoleSelect(String value){
       selectByVisibleTextFromDropDown(userRoleSelect ,value);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }

    public void selectStatusEnable(String value){
        selectByVisibleTextFromDropDown(selectEnable,value);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }
    public String setVerifyTheResult(){
        return getTextFromElement(verifyTheResult);
    }
    public void setTickOnCheckbox() {
        clickOnElement(tickOnCheckbox);
    }
        public void setClickOnDeleteButton(){
            clickOnElement(clickOnDeleteButton);
        }
    public void verifyThePopUpWindowIsDisplayed() {
        verifyThatElementIsDisplayed(popUpWindow);
    }

    public void clickOnYesButton() {
        clickOnElement(yesButton);
    }

    public void verifyNoRecordFoundMessage(String text) {
        verifyThatTextIsDisplayed(noRecordFound, text);
    }

    public void verifyUsernameLabel(String text) {
        verifyThatTextIsDisplayed(verifyUsername, text);
    }

    public void clickOnReSetButton() {
        clickOnElement(reSetButton);
    }

public void addDetails(String username ,String userRole,String employeeName, String Status){
        setEnterTheUserName(username);
        setEnterEmployeeName(employeeName);
        setUserRoleSelect(userRole);
         selectStatusEnable(Status);



}


}
