import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class exercise1 {

    WebDriver driver;


    @BeforeEach
    void setup(){

        driver = new ChromeDriver();
        driver.get("http://192.168.91.198/");

    }


    @Test
    void testCase1() throws InterruptedException {
        driver.findElement(By.cssSelector("a#wishlist-total > .d-md-inline.d-none")).click();

        List<WebElement> listOfButtons = driver.findElements(By.tagName("button"));
        System.out.println(listOfButtons.size());

        driver.findElement(By.id("input-email")).sendKeys("email@email.com");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).clear();

        driver.findElement(By.cssSelector("#content [class='col mb-3']:nth-of-type(1) .btn-primary")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Vardas");
        driver.findElement(By.id("input-lastname")).sendKeys("Pavarde");
        driver.findElement(By.id("input-email")).sendKeys("email@email.com");
        driver.findElement(By.id("input-password")).sendKeys("password123");

        driver.findElement(By.cssSelector("input[name='agree']")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        if(driver.findElement(By.cssSelector(".btn.btn-block.btn-inverse.btn-lg.dropdown-toggle")).isDisplayed()){
            System.out.println(driver.findElement(By.cssSelector(".btn.btn-block.btn-inverse.btn-lg.dropdown-toggle")).getText());
        }

        driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();

        Select dropdownList = new Select(driver.findElement(By.cssSelector("select#input-limit")));

        dropdownList.selectByVisibleText("25");
        dropdownList = new Select(driver.findElement(By.cssSelector("select#input-limit")));
        System.out.println(dropdownList.getFirstSelectedOption().getText());

        dropdownList.selectByVisibleText("50");
        dropdownList = new Select(driver.findElement(By.cssSelector("select#input-limit")));
        System.out.println(dropdownList.getFirstSelectedOption().getText());

        driver.close();


    }

    @Test
    void testCase2(){

        driver.findElement(By.cssSelector("div#search > input[name='search']")).sendKeys("MaxBook");
        driver.findElement(By.cssSelector("div#search > .btn.btn-lg.btn-light")).click();

        driver.findElement(By.id("button-search")).isDisplayed();

        driver.findElement(By.cssSelector("div#search > input[name='search']")).clear();

        driver.findElement(By.cssSelector("div#search > input[name='search']")).sendKeys("MacBook");
        driver.findElement(By.cssSelector("div#search > .btn.btn-lg.btn-light")).click();

        List<WebElement> products = driver.findElements(By.cssSelector("div.col.mb-3"));
        System.out.println(products.size());

        Select dropdownOptions =  new Select(driver.findElement(By.cssSelector("select#input-sort")));
        dropdownOptions.selectByVisibleText("Price (Low > High)");

        dropdownOptions = new Select(driver.findElement(By.cssSelector("select#input-sort")));
        System.out.println(dropdownOptions.getFirstSelectedOption().getText());

        driver.close();

    }









}
