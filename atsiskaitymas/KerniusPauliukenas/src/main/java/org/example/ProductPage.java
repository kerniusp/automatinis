package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ProductPage extends BasePage{


    public ProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "button.wishlist-button-add>.material-icons")
    WebElement buttonHearth;

    @FindBy(css = ".modal-text")
    WebElement pNeedToBeLoggedInText;

    @FindBy(css = ".wishlist-login > div[role='dialog'] > div[role='document'] .btn.btn-secondary.modal-cancel")
    WebElement buttonCancel;

    @FindBy(css = "select[name='group[1]']")
    WebElement selectDropDownSize;

    @FindBy(css = "button.add-to-cart")
    WebElement buttonAddToCart;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/h4")
    WebElement h4SuccessMessage;

    @FindBy(css = ".cart-content-btn > a")
    WebElement buttonProccedToCheckout;

    @FindBy(css ="div.text-sm-center > a")
    WebElement ahrefProccedToCheckout;

    public void clickWishlist(){
        buttonHearth.click();
    }

    public String getTextOfwishlist(){
        return pNeedToBeLoggedInText.getText();
    }

    public void clickCancel(){
        buttonCancel.click();
    }

    public void clickDropDownSize(){
        selectDropDownSize.click();
    }

    public void selectSize(String size){
        Select sizeDropdown = new Select(selectDropDownSize);
        sizeDropdown.selectByVisibleText(size);
    }

    public void clickAddToCart(){
        buttonAddToCart.click();
    }

    public String getMessageAfterAddingProduct(){
        return h4SuccessMessage.getText();
    }

    public void clickProccedCheckout(){
        buttonProccedToCheckout.click();
    }

    public void clickShoppingCartsProccedToCheckout(){
        ahrefProccedToCheckout.click();
    }




}
