package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(id="field-email")
    private WebElement fieldEmail;

    @FindBy(id="field-password")
    private WebElement fieldPassword;

    @FindBy(id="submit-login")
    private WebElement buttonLogin;


    @FindBy(css="[data-link-action='display-register-form']")
    private WebElement ahrefRegister;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegistration(){
        ahrefRegister.click();
    }

    public void enterEmail(String email){
        fieldEmail.sendKeys(email);
    }

    public void enterPassword(String pass){
        fieldPassword.sendKeys(pass);
    }

    public void clickLogin(){
        buttonLogin.click();
    }
}
