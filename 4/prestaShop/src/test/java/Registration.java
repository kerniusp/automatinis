import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.Constants.CHARACTERS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Registration {

    WebDriver driver;
    String username = randomName();
    String lastname = randomName();

    String[] gmails = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "example.com"};
    String email = randomEmail();
    String password = "slaptazodis123+-RS*";
    @BeforeEach
    void startup() {

        driver = new ChromeDriver();
        driver.get("http://192.168.89.130/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    void registrationProfileAndLogin(){

        driver.findElement(By.cssSelector(".user-info [title]")).click();
        driver.findElement(By.cssSelector("[data-link-action='display-register-form']")).click();


        driver.findElement(By.id("field-id_gender-1")).click();

        driver.findElement(By.id("field-firstname")).sendKeys(username);
        driver.findElement(By.id("field-lastname")).sendKeys(lastname);
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);
        driver.findElement(By.id("field-birthday")).sendKeys("08/05/2001");
        driver.findElement(By.cssSelector("input[name='newsletter']")).click();
        driver.findElement(By.cssSelector("input[name='psgdpr']")).click();
        driver.findElement(By.cssSelector("input[name='customer_privacy']")).click();

        driver.findElement(By.cssSelector(".btn.btn-primary.float-xs-right.form-control-submit")).click();
        driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();


        assertEquals("http://192.168.89.130/my-account",driver.getCurrentUrl(),"Incorrect URL link, " +
                "\nafter finishing registration it should navigate to the users profile");
        assertEquals(username + " " + lastname,driver.findElement(By.cssSelector("[title] .hidden-sm-down")).getText());

        driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
        driver.findElement(By.cssSelector("div#_desktop_user_info .hidden-sm-down")).click();

        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);

        driver.findElement(By.id("submit-login")).click();

        driver.findElement(By.cssSelector("a#identity-link > .link-item")).click();

        WebElement inputElement = driver.findElement(By.id("field-firstname"));
        String inputValue = inputElement.getAttribute("value");


        WebElement inputElement2 = driver.findElement(By.id("field-lastname"));
        String inputValue2 = inputElement2.getAttribute("value");

        assertEquals(username,inputValue,"username values do no match");
        assertEquals(lastname,inputValue2,"lastname values do not match");
        assertEquals(email,driver.findElement(By.id("field-email")).getAttribute("value"),"emails do not match");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataforTesting.csv",numLinesToSkip = 1)
    void registrationData(String username, String lastname, String email,String password){

        driver.findElement(By.cssSelector(".user-info [title]")).click();
        driver.findElement(By.cssSelector("[data-link-action='display-register-form']")).click();

        driver.findElement(By.id("field-firstname")).sendKeys(username);
        driver.findElement(By.id("field-lastname")).sendKeys(lastname);
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);

        driver.findElement(By.cssSelector("input[name='newsletter']")).click();
        driver.findElement(By.cssSelector("input[name='psgdpr']")).click();
        driver.findElement(By.cssSelector("input[name='customer_privacy']")).click();

        driver.findElement(By.cssSelector(".btn.btn-primary.float-xs-right.form-control-submit")).click();

        assertEquals("http://192.168.89.130/registration",driver.getCurrentUrl());
    }

    String randomName(){

        Random random = new Random();
        StringBuilder word = new StringBuilder();

        // Build the word by picking random characters
        for (int i = 0; i < 15; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            word.append(CHARACTERS.charAt(randomIndex));
        }

        return word.toString();

    }

    String randomEmail(){
        Random random = new Random();

        // Generate random username
        String username = randomName();

        // Pick a random domain from the list
        String domain = gmails[random.nextInt(gmails.length)];

        // Combine username and domain to form the email
        return username + "@" + domain;
    }




}
