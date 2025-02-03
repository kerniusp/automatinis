import org.example.BasePage;
import org.example.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class testAddTask extends BaseTest{



    @Test
    void mainFunctionality(){
        MainPage mainPage = new MainPage(driver);

        mainPage.enterTask(getTask1());
        Assert.assertEquals(getTask1(), mainPage.getLastTask());

        mainPage.enterTask(getTask2());
        Assert.assertEquals(getTask2(),mainPage.getLastTask());

        mainPage.clickFirstToDoTask();

        System.out.println(mainPage.checkIfFirstTaskIsSelected());
        Assert.assertTrue(mainPage.checkIfFirstTaskIsSelected());

        mainPage.clickCompleted();
        Assert.assertTrue(mainPage.checkIfAppearInCompleted(getTask1()));

    }

}
