import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testActions {

    WebDriver driver;
    Actions action;

    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        action = new Actions(driver);

    }

    @Test
    void dragAndDrop(){



        WebElement draggingBox = driver.findElement(By.cssSelector("div#draggable"));

        action.contextClick(draggingBox)
                .dragAndDrop(draggingBox,driver.findElement(By.id("droppable")))
                .perform();

        WebElement backgroundColor = driver.findElement(By.cssSelector("div#droppable > p"));


        assertEquals("rgba(244, 89, 80, 1)",backgroundColor.getCssValue("background-color"));
        assertEquals("Dropped!",driver.findElement(By.id("droppable")).getText());
    }

    @Test
    void doubleTestClick(){

        WebElement boxForDoubleClick = driver.findElement(By.id("double-click"));

        action.contextClick(boxForDoubleClick)
                .doubleClick()
                .perform();

        WebElement boxBackgroundColor = driver.findElement(By.id("double-click"));

        assertEquals("rgba(147, 203, 90, 1)",boxBackgroundColor.getCssValue("background-color"));

    }

    @Test
    void hoverMouse(){

        List<WebElement> allToHover = driver.findElements(By.cssSelector("div#div-hover button"));

        allToHover.forEach(element -> {
            hoverAndCheckLink(element);

        });

    }

    public void hoverAndCheckLink(WebElement element){

        try {

            action.contextClick(element)
                    .moveToElement(element)
                    .perform();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#div-hover button")));


            WebElement dropdownContent = dropdownButton.findElement(By.className("dropdown-content"));


            assertTrue(element.isDisplayed());

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
        }

    }
}
