import org.example.MainPage;
import org.example.RegistrationPage;
import org.example.SignInPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpTest extends BaseTest{



    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void registartion(String firstName, String lastName, String email, String password){

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignUp();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickCreateAccount();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickTitleMr();
        registrationPage.enterFirstname(firstName);
        registrationPage.enterLastname(lastName);
        registrationPage.enterEmail(email);

        registrationPage.enterPassword(password);

        registrationPage.checkTermsAndConditions();
        registrationPage.checkNewsletter();
        registrationPage.checkCustomerData();

        registrationPage.clickSave();
        String accountName = mainPage.accountName();
        assertEquals(accountName,firstName + " " + lastName,"account full name does not match with the registration data");

        mainPage.clickLogout();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void login(String firstName, String lastName, String email, String password){

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignUp();

        SignInPage signInPage = new SignInPage(driver);

        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        signInPage.clickSignIn();


        assertTrue(mainPage.isLogoutVisible(),"Login wasn't successful");


    }
}
