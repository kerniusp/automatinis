import org.example.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletingMeal extends BaseTest{

    @Test
    public void deletingMealTest(){

        MainPage mainPage = new MainPage(driver);
        mainPage.clickConsent();

        for(int i = 0; i < 4; i++){
            addingMeal(mainPage);
            assertEquals(name + ": " + calories + " Calories",mainPage.getLatestMealInString());
        }
        mainPage.clickEdit(1);
        mainPage.clickDelete();

    }
}
