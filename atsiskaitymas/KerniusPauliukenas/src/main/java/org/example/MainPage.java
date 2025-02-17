package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".user-info")
    WebElement divSignUp;

    @FindBy(css = "div.user-info > a.account > span")
    WebElement spanAccountName;

    @FindBy(css = "a.logout")
    WebElement ahrefLogout;

    @FindBy(css = "input[name='s']")
    WebElement inputSearch;

    public void clickSignUp(){
        divSignUp.click();
    }

    public String accountName(){
        return spanAccountName.getText();
    }

    public void clickLogout(){
        ahrefLogout.click();
    }

    public boolean isLogoutVisible(){
        return ahrefLogout.isDisplayed();
    }

    public void searchForAnItem(String item){
        inputSearch.sendKeys(item + Keys.ENTER);
    }
}
