import org.example.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddingMeal extends BaseTest{

    @Test
    public void addingMealTest(){

       MainPage mainPage = new MainPage(driver);
       mainPage.clickConsent();

       for(int i = 0; i < 3; i++){
            addingMeal(mainPage);
            assertEquals(name + ": " + calories + " Calories",mainPage.getLatestMealInString());
        }

    }
}
