package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
    WebElement verifyTestSystemUser;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']" )
    WebElement clickingAddButton ;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]" )
    WebElement enterUsername;






    public String verifyTextSystemUser(){
        return getTextFromElement(verifyTestSystemUser);
    }
    public void clickOnAddButton(){
        clickOnElement(clickingAddButton);
    }
    public void setEnterUsername(String user){
       sendTextToElement(enterUsername,user);
    }

}
