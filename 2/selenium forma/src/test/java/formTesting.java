import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class formTesting {

    @Test
    void form(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().fullscreen();


        driver.findElement(By.id("firstName")).sendKeys("Saulius");
        driver.findElement(By.id("lastName")).sendKeys("Mangruda");
        driver.findElement(By.id("userEmail")).sendKeys("sauliaus@gmail.com");
        driver.findElement(By.cssSelector("div#genterWrapper > .col-md-9.col-sm-12 > div:nth-of-type(1) > label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("37060463814");

        driver.findElement(By.id("dateOfBirthInput")).click();

        Select yearSelection = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        yearSelection.selectByVisibleText("2001");

        Select monthSelection = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        monthSelection.selectByVisibleText("May");

        driver.findElement(By.cssSelector("div[role='listbox'] > div:nth-of-type(2) > div:nth-of-type(3)")).click();

        driver.findElement(By.cssSelector("div#hobbiesWrapper > .col-md-9.col-sm-12 > div:nth-of-type(1) > label")).click();

        WebElement element = driver.findElement(By.id("subjectsInput"));
        element.sendKeys("com");
        element.sendKeys(Keys.ENTER);

        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\D2PT\\Desktop\\profile-icon-design-free-vector.jpg");

        driver.findElement(By.id("currentAddress")).sendKeys("Juozapaccio gatve 55-5");

        WebElement inputState = driver.findElement(By.id("react-select-3-input"));
        inputState.sendKeys("NCR");
        inputState.sendKeys(Keys.ENTER);

        WebElement inputCity = driver.findElement(By.id("react-select-4-input"));
        inputCity.sendKeys("Delhi");
        inputCity.sendKeys(Keys.ENTER);

        driver.findElement(By.id("submit")).click();


        assertEquals("Thanks for submitting the form",driver.findElement(By.cssSelector("div#example-modal-sizes-title-lg")).getText());
        assertEquals("Saulius Mangruda",driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(2)")).getText());

    }

}
