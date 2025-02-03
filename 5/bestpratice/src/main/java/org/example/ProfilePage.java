package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a#identity-link > .link-item")
    private WebElement linkInformation;

    @FindBy(id="field-firstname")
    private WebElement fieldName;

    @FindBy(id="field-lastname")
    private WebElement fieldlastName;

    @FindBy(id="field-email")
    private WebElement fieldEmail;

    public void clickLinkInformation(){
        linkInformation.click();
    }

    public String getUserNames(){
       return fieldName.getAttribute("value") + " " + fieldlastName.getAttribute("value");
    }

    public String getEmail(){
        return fieldEmail.getAttribute("value");
    }
}
