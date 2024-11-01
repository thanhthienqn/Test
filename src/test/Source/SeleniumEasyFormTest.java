package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumEasyFormTest {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void testSeleniumEasyForm() {
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name"))).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("email")).sendKeys("johndoe@example.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("address")).sendKeys("123 Main St");
        driver.findElement(By.name("city")).sendKeys("New York");

        driver.findElement(By.name("state")).sendKeys("New York");

        driver.findElement(By.name("zip")).sendKeys("10001");
        driver.findElement(By.name("website")).sendKeys("https://example.com");

        driver.findElement(By.xpath("//input[@value='yes']")).click();
        driver.findElement(By.name("comment")).sendKeys("This is a sample project description.");

        driver.findElement(By.cssSelector(".btn")).click();
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        SeleniumEasyFormTest test = new SeleniumEasyFormTest();
        test.setUp();
        test.testSeleniumEasyForm();
        test.tearDown();
    }
}
