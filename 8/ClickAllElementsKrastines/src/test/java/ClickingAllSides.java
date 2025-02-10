import org.example.MainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickingAllSides{

    WebDriver driver;

    @Test
    public void clickingAllCorners(){

        driver = new ChromeDriver();
        driver.get("file:///C:/Users/ITWORK/Downloads/QApraktinisKrastines.html");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        MainPage mainPage = new MainPage(driver);
        String doneMessage;

            while(true){

                if(mainPage.isAlertPresent() && mainPage.getAlert().getText().equals("DONE! Congratulations on completing the task!")){
                    doneMessage = mainPage.getAlert().getText();
                    break;
                }else if(mainPage.isAlertPresent()){
                    mainPage.acceptAlert();
                }else{
                    mainPage.clickFirstRow();
                    mainPage.clickInBetweenRows();
                    mainPage.clickLastRow();
                }

            }
            assertEquals("DONE! Congratulations on completing the task!",doneMessage);




    }
}
