import org.example.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddCompleteTest extends BaseTest{



    @Test
    void mainFunctionality(){
        MainPage mainPage = new MainPage(driver);


        //Prideda 3 taskus
        for(int i = 0; i <= 3; i++){
            String output = getTask() + i;
            mainPage.enterTask(output);
            Assert.assertEquals(output, mainPage.getLastTask());
        }


        //Pazymi pirma ir paskutini task kaip completed
        mainPage.clickFirstToDoTask();
        mainPage.clickLastToDoTask();

        Assert.assertTrue(mainPage.checkIfTaskIsCompleted(mainPage.getFirstCompletedElement()));
        Assert.assertTrue(mainPage.checkIfTaskIsCompleted(mainPage.getLastCompletedElement()));




        //Patikrina ar paspaudus completed rodo tik completed taskus
        mainPage.clickCompleted();

        for(int i = 0; i < mainPage.getCompletedTasks().size(); i++){

            Assert.assertTrue(mainPage.checkIfAppearInCompleted(mainPage.getCompletedTasks().get(i)));

        }

    }

}
