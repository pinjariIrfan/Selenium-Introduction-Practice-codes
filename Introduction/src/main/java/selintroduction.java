import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class selintroduction {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver",
            "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 1: Login with wrong password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();

        // Print error message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Step 2: Forgot Password flow
        driver.findElement(By.linkText("Forgot your password?")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='Name']")));

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        WebElement phoneOrEmail = driver.findElement(
            By.cssSelector("input[type='text']:nth-child(3)"));
        phoneOrEmail.clear();
        phoneOrEmail.sendKeys("john@gmail.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8690690747");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // Print success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form p")));
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        // Step 3: Go back to Login
        driver.findElement(
            By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        // Step 4: Login with correct password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        // Step 5: Click checkbox via JS
        WebElement checkbox = driver.findElement(By.id("chkboxOne"));
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        js.executeScript("arguments[0].click();", checkbox);

        // Step 6: Submit
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'submit')]")));
        submitBtn.click();
    }
}