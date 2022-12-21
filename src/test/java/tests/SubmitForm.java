package tests;

import org.testng.annotations.Test;
import pageobjects.ContactPage;
import testcomponents.BaseTest;

public class SubmitForm extends BaseTest {
    public void SubmitForm()
    {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.userApplication("Patryk Osowski", "deny1223@hotmail.com",
                "Job Application", "I would like to say, I finish the job");
        contactPage.clickCookiesButton();
    }

}
