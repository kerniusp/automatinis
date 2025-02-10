import org.example.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickingElements extends BaseTest{

    @Test
    public void clickingAllElements(){

        MainPage mainPage = new MainPage(driver);
        String doneMessage;

        while(true) {

            if (mainPage.isAlertPresent() && mainPage.getAlert().getText().equals("DONE! Congratulations on completing the task!")) {
                doneMessage = mainPage.getAlert().getText();
                break;
            }else if(mainPage.isAlertPresent()){
                mainPage.acceptAlert();
            }
            else {
                mainPage.clickButton();
            }
        }

        assertEquals("DONE! Congratulations on completing the task!",doneMessage);

    }
}
