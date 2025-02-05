import org.example.MainPage;
import org.junit.Assert;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ClearCompleted extends  BaseTest{

    @Test
    void addingTaskAndClickingClearComplete(){

        MainPage mainPage = new MainPage(driver);

        addTask(mainPage,5);

        int listSizeBeforeClickingClearCompleted = mainPage.getListOfTasks().size();
        mainPage.clickClearCompleted();

        int listSizeAfterClickingClearCompleted = mainPage.getListOfTasks().size();

        assertThat(listSizeBeforeClickingClearCompleted)
                .isEqualTo(listSizeAfterClickingClearCompleted);

    }

    @Test
    void checkingTaskAndClickingClearCompleted(){

        MainPage mainPage = new MainPage(driver);

        addTask(mainPage,7);
        int listSizeOfTask = mainPage.getListOfTasks().size();

        int counter = 0;
        for(int i = 0; i < 4; i++){
            mainPage.clickToggle(i);
            counter++;
        }

        mainPage.clickClearCompleted();

        int listSizeAfterClickingCompleted = mainPage.getListOfTasks().size();


        assertThat(listSizeAfterClickingCompleted).isEqualTo(listSizeOfTask - counter);



    }


}
