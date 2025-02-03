import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class test {

    WebDriver driver;

    @BeforeEach
    void startup(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    void testLogin(){

        String loginName = driver.findElement(By.cssSelector(".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(1)")).getText();
        System.out.println(loginName);
        String[] words = loginName.split(" ");


        String password = driver.findElement(By.cssSelector(".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(2)")).getText();
        System.out.println(password);
        String[] pw = password.split(" ");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(words[2]);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pw[2]);

        driver.findElement(By.cssSelector(".orangehrm-login-action.oxd-form-actions > .orangehrm-login-button.oxd-button.oxd-button--main.oxd-button--medium")).click();
    }

}
