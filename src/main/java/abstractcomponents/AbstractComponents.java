package abstractcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.ContactPage;


public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[id='cookie-law-btn']")
    WebElement cookieButton;

    public ContactPage clickCookiesButton() {
        cookieButton.click();
        ContactPage contactPage = new ContactPage(driver);
        return contactPage;
    }

}
