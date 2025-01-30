import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMinus {

    WebDriver driver;

    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/calculator");

    }

    @Test
    void testCaseMinus(){

        driver.findElement(By.id("number1")).sendKeys("3");

        Select dropdownOptions = new Select(driver.findElement(By.id("function")));
        dropdownOptions.selectByValue("minus");

        driver.findElement(By.id("number2")).sendKeys("2");

        driver.findElement(By.id("calculate")).click();

        assertEquals("1",driver.findElement(By.id("answer")).getText());

    }

}
