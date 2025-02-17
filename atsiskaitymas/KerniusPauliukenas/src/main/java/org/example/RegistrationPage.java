package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css ="[for='field-id_gender-1']")
    WebElement radioSocialTitleMr;

    @FindBy(id = "field-firstname")
    WebElement inputFirstname;

    @FindBy(id = "field-lastname")
    WebElement inputLastname;

    @FindBy(id = "field-email")
    WebElement inputEmail;

    @FindBy(id = "field-password")
    WebElement inputPassword;

    @FindBy(css = "[name='psgdpr']")
    WebElement checkboxTermsAndConditions;

    @FindBy(css = "[name='newsletter']")
    WebElement checkboxNewsletter;

    @FindBy(css = "[name='customer_privacy']")
    WebElement checkboxCustomerData;

    @FindBy(css = "button.btn.btn-primary.form-control-submit")
    WebElement buttonSave;


    public void clickTitleMr(){
        radioSocialTitleMr.click();
    }

    public void enterFirstname(String name){
        inputFirstname.sendKeys(name);
    }

    public void enterLastname(String lastname){
        inputLastname.sendKeys(lastname);
    }

    public void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void checkTermsAndConditions(){
        checkboxTermsAndConditions.click();
    }

    public void checkNewsletter(){
        checkboxNewsletter.click();
    }

    public void checkCustomerData(){
        checkboxCustomerData.click();
    }

    public void clickSave(){
        buttonSave.click();
    }



}
