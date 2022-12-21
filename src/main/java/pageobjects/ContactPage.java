package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(css = "input[type='submit']")
    WebElement sendButton;

    @FindBy(css = ".wpcf7-response-output")
    WebElement message;

    public void userApplication(String name, String email, String subject, String message) {
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        userSubject.sendKeys(subject);
        userMessage.sendKeys(message);

    }

    public void goTo() {
        driver.get("https://sourceful.nl/nl/contact-pl/");
        Actions actions = new Actions(driver);
        actions.moveToElement(sendButton);
    }

    public void waitForReCaptcha() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();
        driver.switchTo().defaultContent();
    }
    public void sendForm() throws InterruptedException {
        sendButton.click();
        Thread.sleep(3000);
    }
    public String verifyMessageIsDisplayed(){
        return message.getText();
    }
}
