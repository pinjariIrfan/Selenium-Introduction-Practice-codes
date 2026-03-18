import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        // ✅ Always use ChromeTemp — this is your signed-in profile copy
        options.addArguments("user-data-dir=C:\\ChromeTemp");
        options.addArguments("profile-directory=Profile 3");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Irfan");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Irfan@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}