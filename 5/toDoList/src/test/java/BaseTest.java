import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {


    private String task1 = "To do dishes";
    private String task2 = "Cook dinner";
    WebDriver driver;

    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public String getTask1() {
        return task1;
    }

    public String getTask2() {
        return task2;
    }
}
