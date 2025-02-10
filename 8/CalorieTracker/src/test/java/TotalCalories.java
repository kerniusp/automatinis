import org.example.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalCalories extends BaseTest{


    @Test
    public void matchingCalorieNumber(){

        MainPage mainPage = new MainPage(driver);
        mainPage.clickConsent();

        int valueOfCaloriesInInt = 0;
        for(int i = 0; i < 2; i++){
            addingMeal(mainPage);
            assertEquals(name + ": " + calories + " Calories",mainPage.getLatestMealInString());
            valueOfCaloriesInInt = Integer.parseInt(calories);
            valueOfCaloriesInInt += valueOfCaloriesInInt;
        }

        String sumInString = valueOfCaloriesInInt + "";
        assertEquals(sumInString, mainPage.getTextOfCalories());
    }

}
