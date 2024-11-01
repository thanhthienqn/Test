package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SaucedemoTest {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void testSaucedemo() {
        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
        System.out.println("Logged in successfully. First product: " + firstItem.getText());
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        SaucedemoTest test = new SaucedemoTest();
        test.setUp();
        test.testSaucedemo();
        test.tearDown();
    }
}
