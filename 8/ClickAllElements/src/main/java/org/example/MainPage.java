package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{




    public MainPage(WebDriver driver){
        super(driver);

    }

    @FindBy(css = ".icon")
    List<WebElement> divButtons;

    public void clickButton(){
        divButtons.forEach(button -> button.click());
    }

    public void acceptAlert(){
        getAlert().accept();
    }



}
