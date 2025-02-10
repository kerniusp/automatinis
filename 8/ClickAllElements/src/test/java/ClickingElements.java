import org.example.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

public class ClickingElements extends BaseTest{

    @Test
    public void clickingAllElements(){

        MainPage mainPage = new MainPage(driver);

        while(true) {

            if (mainPage.isAlertPresent() && mainPage.getAlert().getText().equals("DONE! Congratulations on completing the task!")) {
                break;
            }else if(mainPage.isAlertPresent()){
                mainPage.acceptAlert();
            }
            else {
                mainPage.clickButton();
            }
        }

    }
}
