package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }


    @FindBy(css = ".fc-button-label")
    WebElement pConsent;

    @FindBy(id = "item-name")
    WebElement inputAddItem;

    @FindBy(id = "item-calories")
    WebElement inputCalories;

    @FindBy(css = ".add-btn.blue.btn.darken-3")
    WebElement buttonAddMeal;

    @FindBy(css = "li.collection-item:last-child")
    WebElement liLatestAddedMeal;

    @FindBy(css = "span.total-calories")
    WebElement numberOfCalories;

    @FindBy(css = ".edit-item")
    List<WebElement> iEdit;

    @FindBy(css = ".btn.delete-btn.red")
    WebElement buttonDelete;

    public void clickDelete(){
        buttonDelete.click();
    }

    public void clickEdit(int number){
        iEdit.get(number).click();
    }

    public String getTextOfCalories(){
        return numberOfCalories.getText();
    }

    public String getLatestMealInString(){
          return liLatestAddedMeal.getText();
    }

    public void clickingButtonAddMeal(){
        buttonAddMeal.click();
    }

    public void addMeal(String mealsName){
        inputAddItem.sendKeys(mealsName);
    }

    public void addCalories(String calories){
        inputCalories.sendKeys(calories);
    }

    public void clickConsent(){
        pConsent.click();
    }
}
