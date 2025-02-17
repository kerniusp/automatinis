import org.example.CheckoutPage;
import org.example.MainPage;
import org.example.ProductPage;
import org.example.SearchResultPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest extends BaseTest{


    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void searchTest(String Product,String Price,String Discount,String Size){

        MainPage mainPage = new MainPage(driver);
        mainPage.searchForAnItem(Product);

        SearchResultPage searchResultPage = new SearchResultPage(driver);

        assertTrue(searchResultPage.isProductDisplayed(),"Item was not found");
        assertEquals(searchResultPage.nameOfDisplayedProduct().toLowerCase(),Product.toLowerCase(),"displayed product name does not match with entered searched products name");

        searchResultPage.clickProduct();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void wishlistTest(String Product,String Price,String Discount,String Size){

        MainPage mainPage = new MainPage(driver);
        mainPage.searchForAnItem(Product);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickWishlist();

        assertEquals(productPage.getTextOfwishlist(),"You need to be logged in to save products in your wishlist.","You shouldn't be able to add product to wishlist without an account");
        productPage.clickCancel();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void shoppingCartTest(String Product,String Price,String Discount,String Size){

        MainPage mainPage = new MainPage(driver);
        mainPage.searchForAnItem(Product);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickDropDownSize();
        productPage.selectSize(Size);
        productPage.clickAddToCart();


        System.out.println(productPage.getMessageAfterAddingProduct());
        //assertEquals("Product successfully added to your shopping cart",productPage.getMessageAfterAddingProduct(),"After adding product to cart there isn't a success pop with confirmation message");
        productPage.clickProccedCheckout();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void checkoutConfirmationTest(String Product,String Price,String Discount,String Size){

        MainPage mainPage = new MainPage(driver);
        mainPage.searchForAnItem(Product);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickDropDownSize();
        productPage.selectSize(Size);


        productPage.clickAddToCart();
        productPage.clickProccedCheckout();
        productPage.clickShoppingCartsProccedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickShowDetails();


        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getAhrefProductName()));

        assertEquals(checkoutPage.getProductName().toLowerCase(),Product.toLowerCase(),"Products name in the checkout does not match with the test data that was used");

        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getSpanSizeOfProduct()));
        assertEquals(checkoutPage.getSizeOfProduct(),Size,"Products size in checkout doesn't match with the data size that was provided when selecting an item");

        double ogPrice = Double.parseDouble(Price);
        double discount = Double.parseDouble(Discount);

        double priceWithDiscount = ogPrice - (ogPrice * discount)/100;

        BigDecimal priceWithDiscountRounded = new BigDecimal(priceWithDiscount);
        priceWithDiscountRounded = priceWithDiscountRounded.setScale(2, RoundingMode.HALF_UP);

        BigDecimal checkoutPrice = BigDecimal.valueOf(checkoutPage.getPrice());

        assertEquals(priceWithDiscountRounded,checkoutPrice,"Discount of 20% was not applied correctly to the original price");



    }



}
