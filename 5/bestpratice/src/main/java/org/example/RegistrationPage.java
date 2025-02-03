package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(css=".col-md-6.form-control-valign.js-input-column > label:nth-of-type(1)")
    private WebElement radioForMaleGender;

    @FindBy(id="field-firstname")
    private WebElement fieldFirstname;

    @FindBy(id="field-lastname")
    private WebElement fieldLastname;

    @FindBy(id="field-email")
    private WebElement fieldGmail;

    @FindBy(id="field-password")
    private WebElement fieldPassword;

    @FindBy(css="input[name='psgdpr']")
    private WebElement checkboxTermsAndCondition;

    @FindBy(css="input[name='newsletter']")
    private WebElement checkboxSignUpForNewSletter;

    @FindBy(css="input[name='customer_privacy']")
    private WebElement checkboxCustomerDataPrivacy;

    @FindBy(css=".btn.btn-primary.float-xs-right.form-control-submit")
    private WebElement buttonSave;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickMrTitle(){
        radioForMaleGender.click();
    }

    public void enterFirstname(String name){
        fieldFirstname.sendKeys(name);
    }

    public void enterLastname(String lastname){
        fieldLastname.sendKeys(lastname);
    }

    public void enterEmail(String gmail){
        fieldGmail.sendKeys(gmail);
    }

    public void enterPassword(String password){
        fieldPassword.sendKeys(password);
    }

    public void clickTermsAndConditions(){
        checkboxTermsAndCondition.click();
    }

    public void clickSignUpForNews(){
        checkboxSignUpForNewSletter.click();
    }

    public void clickCustomerDataPrivacy(){
        checkboxCustomerDataPrivacy.click();
    }

    public void clickSave(){
        buttonSave.click();
    }






}
