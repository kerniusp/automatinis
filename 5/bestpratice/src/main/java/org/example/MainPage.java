package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends  BasePage{


    @FindBy(css="div#_desktop_user_info .hidden-sm-down")
    private WebElement ahrefSignIn;

    @FindBy(css="a[title='View my customer account']")
    private WebElement ahrefProfile;

    @FindBy(css=".hidden-sm-down.logout")
    private WebElement ahrefLogout;

    @FindBy(css="[title] .hidden-sm-down")
    private WebElement spanProfile;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn(){
        ahrefSignIn.click();
    }

    public void clickProfile(){
        ahrefProfile.click();
    }

    public void clickLogout(){
        ahrefLogout.click();
    }

    public String getUsername(){
        return spanProfile.getText();
    }

}
