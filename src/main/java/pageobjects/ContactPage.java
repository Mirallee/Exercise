package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends AbstractComponents {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@name='your-name'])[1]")
    WebElement userName;

    @FindBy(css = "input[name='your-email']")
    WebElement userEmail;

    @FindBy(css = "input[name='your-subject']")
    WebElement userSubject;

    @FindBy(css = "textarea[name='your-message']")
    WebElement userMessage;

    public void userApplication(String name, String email, String subject, String message)
    {
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        userSubject.sendKeys(subject);
        userMessage.sendKeys(message);

    }
    public void goTo()
    {
        driver.get("https://sourceful.nl/nl/contact-pl/");
    }
}
