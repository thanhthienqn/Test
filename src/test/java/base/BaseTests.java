package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        System.out.println("Title: " + driver.getTitle());

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("johndoe@example.com");

        WebElement genderRadio = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        genderRadio.click();

        WebElement mobile = driver.findElement(By.id("userNumber"));
        mobile.sendKeys("1234567890");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.className("modal-title"));
        System.out.println("Confirmation Message: " + confirmationMessage.getText());

        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
