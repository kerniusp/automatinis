import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv",numLinesToSkip = 1)
    void testWithCsvFileSaureFromFile(String username,String password){

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();


    }

    @Test
    void timeTest(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertTimeout(Duration.ofSeconds(2),() -> driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed());

    }



    @Test
    void pirkiniukrepselis(){

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();


        assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl(),"Incorrect link");
        assertTrue(driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed());


    }

    @Test
    void wrongUserLogin(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");

        driver.findElement(By.id("login-button")).click();

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(By.tagName("h3")).getText();

        assertEquals(expected,actual,"Incorrect message for entering the wrong password");


    }

    @Test
    void lockedUser(){


        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String expected = "Epic sadface: Sorry, this user has been locked out.";
        String actual = driver.findElement(By.tagName("h3")).getText();

        assertEquals(expected,actual,"Incorrect message for the locked out user");

    }


}
