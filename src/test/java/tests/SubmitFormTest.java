package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitFormTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void submitForm(HashMap<String, String> input) throws InterruptedException {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.userApplication(input.get("name"), input.get("email"), input.get("subject"), input.get("message"));
        contactPage.waitForReCaptcha();
        contactPage.sendForm();
        String confirmMessage = contactPage.verifyMessageIsDisplayed();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Dziękujemy, wiadomość została wysłana."));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(0)}};
    }

}
