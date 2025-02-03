package org.example;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class BaseTest {

    WebDriver driver;

    public String name = "Tomas";
    public String lastname = "Tomauskas";
    public String gmail = "vardas17@gmail.com";
    public String password = "slapt123!DD";


    @BeforeEach
    void startup(){
        driver = new ChromeDriver();
        driver.get("http://192.168.89.130/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterEach
    void tearDown(){

        if(driver != null){
            driver.quit();
        }
    }

}
