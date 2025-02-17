package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".no-account > a")
    WebElement ahrefCreateAccount;

    @FindBy(id = "field-email")
    WebElement inputEmail;

    @FindBy(id = "field-password")
    WebElement inputPassword;

    @FindBy(id = "submit-login")
    WebElement buttonSignIn;

    public void clickCreateAccount(){
        ahrefCreateAccount.click();
    }

    public void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickSignIn(){
        buttonSignIn.click();
    }
}
