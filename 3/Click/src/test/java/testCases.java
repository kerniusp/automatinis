import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCases {


    WebDriver driver;

    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    void webElementClick(){

        driver.findElement(By.id("button1")).click();
    }

    @Test
    void javaScriptClick(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('button2').click();");
    }

    @Test
    void actionClick(){

        Actions action = new Actions(driver);
        WebElement submitButton3 = driver.findElement(By.id("button3"));

        action.moveToElement(submitButton3).click().perform();
    }


}
