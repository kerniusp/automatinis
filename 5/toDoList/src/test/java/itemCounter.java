import org.example.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class itemCounter extends BaseTest{


    @Test
    void addingTask(){

        MainPage mainPage = new MainPage(driver);

        int counter = 0;
        for(int i = 1; i <= 3; i++){
            mainPage.enterTask("Task "+ i);
            counter++;
        }
        Assert.assertEquals(counter,mainPage.displayedTextOfCountedList());

    }

    @Test
    void removingTask() {
        MainPage mainPage = new MainPage(driver);

        int counter = 0;
        for(int i = 1; i <= 5; i++){
            mainPage.enterTask("Task "+ i);
            counter++;
        }

        for(int i = 1; i <= 3; i++){
            mainPage.moveMouseAndDeleteTasks();
            counter--;
        }
        Assert.assertEquals(counter,mainPage.displayedTextOfCountedList());


    }
}
