import org.example.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Beta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {

    WebDriver driver;
    String name = "Jerky";
    String calories = "250";

    @BeforeEach
    void startup(){

        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=c4774ba1-f652-4846-96cc-91fc3efcb391&assignmentId=fd8e951b-22c6-4570-83e1-9bb1b9293655&submissionId=49fc8000-9b26-5599-c601-f02660f64a9f#google_vignette");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void addingMeal(MainPage mainPage){

        mainPage.addMeal(name);
        mainPage.addCalories(calories);
        mainPage.clickingButtonAddMeal();

    }
}
