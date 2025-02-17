package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div.thumbnail-container")
    WebElement divContainerOfProduct;

    @FindBy(css = "h2 > a")
    WebElement ahrefProductName;

    public boolean isProductDisplayed(){
        return divContainerOfProduct.isDisplayed();
    }

    public void clickProduct(){
        divContainerOfProduct.click();
    }

    public String nameOfDisplayedProduct(){
        return ahrefProductName.getText();
    }



}
