package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{

    private List<WebElement> completedTasks;

    Actions actions;
    public MainPage(WebDriver driver) {
        super(driver);
        completedTasks = new ArrayList<>();
        actions = new Actions(driver);
    }

    @FindBy(id="todo-input")
    private WebElement fieldToDo;

    @FindBy(css = "li:last-of-type > .view > label")
    private WebElement FieldLastTaskName;

    @FindBy(css = "li > .view > .toggle")
    private WebElement checkboxForFirstElement;

    @FindBy(css = ".todo-list > li:last-child > div > .toggle")
    private WebElement checkboxForLastElement;

    @FindBy(css=".todo-list > li:nth-of-type(1)")
    private WebElement firstCompletedElement;

    @FindBy(css=".todo-list > li:last-child")
    private WebElement lastCompletedElement;

    @FindBy(css=".filters > li:nth-of-type(3) > a")
    private WebElement buttonCompleted;

    @FindBy(css="li[data-testid=todo-item]")
    private List<WebElement> listOfTasks;

    @FindBy(css="li:nth-of-type(1) > .view > .destroy")
    private WebElement firstXButton;

    @FindBy(css=".todo-count")
    private WebElement spanItemsLeft;

    public void enterTask(String task){
        fieldToDo.sendKeys(task);
        fieldToDo.sendKeys(Keys.ENTER);
    }

    public String getLastTask(){
        return FieldLastTaskName.getText();
    }

    public void clickFirstToDoTask(){
        checkboxForFirstElement.click();
        completedTasks.add(firstCompletedElement);
    }

    public void clickLastToDoTask(){
        checkboxForLastElement.click();
        completedTasks.add(lastCompletedElement);
    }

    public boolean checkIfTaskIsCompleted(WebElement completed){

        String classAttribute = completed.getAttribute("class");
        return classAttribute.contains("completed");
    }

    public WebElement getFirstCompletedElement() {
        return firstCompletedElement;
    }

    public WebElement getLastCompletedElement() {
        return lastCompletedElement;
    }

    public void clickCompleted(){
        buttonCompleted.click();
    }

    public void moveMouseAndDeleteTasks() {
        actions.moveToElement(firstCompletedElement).perform();
        firstXButton.click();
    }

    public int displayedTextOfCountedList(){

        String str = spanItemsLeft.getText();
        String[] arrOfStr = str.split(" ");

        return Integer.parseInt(arrOfStr[0]);
    }

    public boolean checkIfAppearInCompleted(WebElement value){
        for(WebElement obj : listOfTasks){
            if(obj.getText().equals(value.getText())){
                return true;
            }
        }
        return false;
    }

    public List<WebElement> getCompletedTasks() {
        return completedTasks;
    }

    public List<WebElement> getListOfTasks() {
        return listOfTasks;
    }


}
