import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bai4 {
    public static void main(String[] args) {
        // Đường dẫn tới ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Khởi tạo trình duyệt
        WebDriver driver = new ChromeDriver();

        // Điều hướng đến trang web
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");

        try {
            // Tạo đối tượng WebDriverWait với thời gian chờ 10 giây
            WebDriverWait wait = new WebDriverWait(driver, 10);

            // Tìm và nhấp vào nút "Get New User"
            WebElement getNewUserButton = driver.findElement(By.id("save"));
            getNewUserButton.click();

            // Chờ đến khi phần tử chứa tên được hiển thị
            WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading']/br/following-sibling::text()[1]")));
            WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading']/br/following-sibling::text()[2]")));

            // Lấy và in ra First Name và Last Name
            String firstName = firstNameElement.getText();
            String lastName = lastNameElement.getText();
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
        } finally {
            // Đóng trình duyệt sau khi hoàn tất
            driver.quit();
        }
    }
}
