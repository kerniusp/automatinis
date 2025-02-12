package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;
import java.util.List;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "ul.nav.navbar-nav > li:last-child")
    WebElement LiMP3player;

    @FindBy(css = ".dropdown-menu.show > .see-all")
    WebElement ahrefShowAllMp3;

    @FindBy(id = "button-list")
    WebElement buttonList;

    @FindBy(css = ".description > h4")
    List<WebElement> listOfMP3Names;

    @FindBy(css = "img[alt='iPod Classic']")
    WebElement divOfiPodClassic;

    @FindBy(id = "input-quantity")
    WebElement inputForItemQuantity;

    @FindBy(id = "button-cart")
    WebElement buttonForCart;

    @FindBy(css = "div#alert")
    WebElement alertOfAddedItem;

    public boolean containsItemNameInAlertMessage(String name){

        if (alertOfAddedItem.getText().contains(name)){
            return true;
        }
        return false;
    }

    public void clickButtonCart(){
        buttonForCart.click();
    }

    public void setARandomNumberForQuantity(String numb){
        inputForItemQuantity.click();
        inputForItemQuantity.clear();
        inputForItemQuantity.sendKeys(numb);

    }

    public void clickOniPodClassic(){
        divOfiPodClassic.click();
    }

    public void clickShowAllMp3(){
        ahrefShowAllMp3.click();
    }
    public void clickMP3player(){
        LiMP3player.click();
    }

    public void clickbuttonList(){
        buttonList.click();
    }

    public String checkIfInsideMP3List(String mp3name){

        for (WebElement mp3 : listOfMP3Names){
            if(mp3.getText().equals(mp3name)){
                return mp3.getText();
            }
        }
        return "Not Found";
    }
}
