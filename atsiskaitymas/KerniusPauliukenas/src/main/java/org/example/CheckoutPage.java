package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div.cart-summary-products > p > a")
    WebElement ahrefShowDetails;

    @FindBy(css ="div.media-body > span > a")
    WebElement ahrefProductName;

    @FindBy(css = ".media-body > div:nth-of-type(1) > .value")
    WebElement spanSizeOfProduct;

    @FindBy(css = "div#cart-subtotal-products > .value")
    WebElement spanPriceAfterDiscount;


    public String getProductName(){
        return ahrefProductName.getText();
    }

    public WebElement getAhrefProductName() {
        return ahrefProductName;
    }

    public void clickShowDetails(){
        ahrefShowDetails.click();
    }

    public String getSizeOfProduct(){
        return spanSizeOfProduct.getText();
    }

    public WebElement getSpanSizeOfProduct() {
        return spanSizeOfProduct;
    }

    public double getPrice(){
        String price = spanPriceAfterDiscount.getText();
        String[] parts = price.split("\\$");

        return Double.parseDouble(parts[1]);
    }
}
