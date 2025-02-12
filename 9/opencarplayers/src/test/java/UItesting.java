import org.example.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UItesting extends BaseTest {

    @Test
    public void test() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickMP3player();
        mainPage.clickShowAllMp3();
        mainPage.clickbuttonList();
        String nameThatWasFound = mainPage.checkIfInsideMP3List("iPod Classic");

        assertEquals("iPod Classic",nameThatWasFound);

        mainPage.clickOniPodClassic();
        mainPage.setARandomNumberForQuantity(randomNumber());
        mainPage.clickButtonCart();
        Thread.sleep(2000);
        boolean messageOfThatItem = mainPage.containsItemNameInAlertMessage("iPod Classic");
        assertTrue(messageOfThatItem,"Items name when added to the cart does not appear on alert message");

    }

    public String randomNumber(){

        int randomNum = 1 + (int)(Math.random() * ((20 - 1) + 1));
        return randomNum + "";

    }
}
