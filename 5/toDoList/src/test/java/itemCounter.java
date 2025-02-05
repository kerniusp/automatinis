import org.example.MainPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class itemCounter extends BaseTest{


    @Test
    void addingTask(){

        MainPage mainPage = new MainPage(driver);

        int countAmount = addTask(mainPage,3);

        Assert.assertEquals(countAmount,mainPage.displayedTextOfCountedList());

    }

    @Test
    void removingTask() {
        MainPage mainPage = new MainPage(driver);

        int countAmount = addTask(mainPage,5);

        for(int i = 1; i <= 3; i++){
            mainPage.moveMouseAndDeleteTasks();
            countAmount--;
        }
        Assert.assertEquals(countAmount,mainPage.displayedTextOfCountedList());


    }

}
