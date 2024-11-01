package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormyFormTest {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void testFormyForm() {
        driver.get("https://formy-project.herokuapp.com/form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys("Jane");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("job-title")).sendKeys("Engineer");

        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();

        driver.findElement(By.cssSelector("option[value='2']")).click();

        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        FormyFormTest test = new FormyFormTest();
        test.setUp();
        test.testFormyForm();
        test.tearDown();
    }
}
