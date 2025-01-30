import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class clickinInShapeOfABox {

    WebDriver driver;
    List<WebElement> rowList;
    List<WebElement> allIcons;
    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/D2PT/Downloads/QApraktinisKrastines%20(1).html");
    }

    @Test
    void clickingInABoxShape(){


        rowList = driver.findElements(By.className("row"));




        for(int i = 0; i < rowList.size(); i++){
            allIcons = driver.findElements(By.className("icon"));
            allIcons.get(i).click();
        }


    }

}
