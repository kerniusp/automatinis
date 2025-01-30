import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAlert {

    WebDriver driver;

    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void aftereach(){

        driver.close();
    }

    @Test
    void javaScriptAlert(){

        driver.findElement(By.id("button1")).click();
        try
        {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert was found");
            alert.accept();
        }
        catch (NoAlertPresentException e)
        {
            System.out.println("No Alert Present");
        }

    }

    @Test
    void javaScriptConfirmBox(){

        driver.findElement(By.id("button4")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        assertEquals("You pressed OK!",driver.findElement(By.id("confirm-alert-text")).getText());

    }

    @Test
    void  modelPopUp(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.id("button2")).click();

        WebElement modelTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-title")));

        assertEquals("It’s that Easy!! Well I think it is.....",modelTitle.getText());

    }

    @Test
    void  ajaxLoader(){

        driver.findElement(By.id("button3")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        WebElement loader = driver.findElement(By.id("loader"));
        WebElement untilLoaderIsGone = wait.until(ExpectedConditions.visibilityOf(loader));

        driver.findElement(By.id("button1")).click();

        WebElement waitForTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-title")));
        assertEquals("Well Done For Waiting....!!!",driver.findElement(By.cssSelector(".modal-title")).getText());


    }


}
