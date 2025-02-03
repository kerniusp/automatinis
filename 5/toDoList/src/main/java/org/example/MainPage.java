package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="todo-input")
    private WebElement fieldToDo;

    @FindBy(css = "li:last-of-type > .view > label")
    private WebElement FieldLastTaskName;

    @FindBy(css = "li > .view > .toggle")
    private WebElement checkboxForFirstElement;

    @FindBy(css=".todo-list > li:nth-of-type(1)")
    private WebElement firstCompletedElement;

    @FindBy(css=".filters > li:nth-of-type(3) > a")
    private WebElement buttonCompleted;

    @FindBy(css="li[data-testid=todo-item]")
    private List<WebElement> listCompleted;

    public void enterTask(String task){
        fieldToDo.sendKeys(task);
        fieldToDo.sendKeys(Keys.ENTER);
    }

    public String getLastTask(){
        return FieldLastTaskName.getText();
    }

    public void clickFirstToDoTask(){
        checkboxForFirstElement.click();
    }

    public boolean checkIfFirstTaskIsSelected(){

        String classAttribute = firstCompletedElement.getAttribute("class");
        return classAttribute.contains("completed");
    }

    public void clickCompleted(){
        buttonCompleted.click();
    }

    public boolean checkIfAppearInCompleted(String value){
        for(WebElement obj : listCompleted){
            if(obj.getText().contains(value)){
                return true;
            }
        }
        return false;
    }
}
