package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    private Alert alert;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        } catch(NoAlertPresentException e){
            return false;
        }
    }
}