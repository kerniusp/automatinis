import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class clickingElements {

    WebDriver driver;

    @BeforeEach
    void startup(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/D2PT/Downloads/QApraktinisALL.html");
    }

    @Test
    void clickingTest(){

        String message = null;

        while(true){

            List<WebElement> elements = driver.findElements(By.className("icon"));

            for(int i = 0; i < elements.size(); i++){

                elements.get(i).click();

            }
            Alert alert = driver.switchTo().alert();
            if(alert.getText().equals("DONE! Congratulations on completing the task!")){
                message = alert.getText();
                break;
            }
            alert.accept();
        }

        assertEquals("DONE! Congratulations on completing the task!",message);



    }







}
