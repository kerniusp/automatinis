package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import java.util.ArrayList;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".row")
    private List<WebElement> divRow;

    @FindBy(css = ".icon")
    private List<WebElement> divButton;

    @FindBy(css = ".row:first-child > .icon")
    private List<WebElement> divFirstRowButton;

    @FindBy(css = ".row:last-child > .icon")
    private List<WebElement> divLastRowButtons;



    public void clickFirstRow() {

       divFirstRowButton.forEach(button -> button.click());

    }

    public void clickInBetweenRows(){

        for(int i = divFirstRowButton.size(); i < divButton.size() - divLastRowButtons.size(); i++){
            if(i % divRow.size() == 0 || i % divRow.size() - (divRow.size() - 1) == 0){
                divButton.get(i).click();

            }


        }
        System.out.print(divFirstRowButton.size() * 2);


    }

    public void clickLastRow() {

        divLastRowButtons.forEach(button -> button.click());

    }

    public void acceptAlert(){
        getAlert().accept();
    }




}
