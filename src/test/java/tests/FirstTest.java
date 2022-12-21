package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://sourceful.nl/nl/contact-pl/");
        driver.findElement(By.xpath("(//input[@name='your-name'])[1]")).sendKeys("Patryk Osowski");
        driver.findElement(By.cssSelector("input[name='your-email']")).sendKeys("deny1223@hotmail.com");
        driver.findElement(By.cssSelector("input[name='your-subject']")).sendKeys("Job Application");
        driver.findElement(By.cssSelector("textarea[name='your-message']")).sendKeys("I would like to say, I finish the job");
        driver.findElement(By.cssSelector("button[id='cookie-law-btn']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();
    }
}
