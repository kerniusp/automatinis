import org.example.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {


    private String task = "task";
    WebDriver driver;


    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public String getTask() {
        return task;
    }

    public int addTask(MainPage mainPage,int numb){
        int counter = 0;
        for(int i = 1; i <= numb; i++){
            mainPage.enterTask("Task "+ i);
            counter++;
        }
        return counter;
    }
}
