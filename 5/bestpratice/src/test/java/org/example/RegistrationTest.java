package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RegistrationTest extends BaseTest{



    @Test
    void registrationTest(){

        MainPage mainPage = new MainPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickSignIn();
        signInPage.clickRegistration();

        registrationPage.clickMrTitle();
        registrationPage.enterFirstname(name);
        registrationPage.enterLastname(lastname);
        registrationPage.enterEmail(gmail);
        registrationPage.enterPassword(password);
        registrationPage.clickTermsAndConditions();
        registrationPage.clickSignUpForNews();
        registrationPage.clickCustomerDataPrivacy();
        registrationPage.clickSave();

        System.out.println(mainPage.getUsername());
        Assert.assertEquals(name + " " + lastname,mainPage.getUsername());

        mainPage.clickLogout();

        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickSignIn();

        signInPage.enterEmail(gmail);
        signInPage.enterPassword(password);
        signInPage.clickLogin();

        mainPage.clickProfile();

        profilePage.clickLinkInformation();


        System.out.println(profilePage.getUserNames());

        Assert.assertEquals(name + " " + lastname, profilePage.getUserNames());
        Assert.assertEquals(gmail,profilePage.getEmail());

    }


}
