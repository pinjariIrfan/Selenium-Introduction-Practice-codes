
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "rahul";
		//System.setProperty("webdriver.edge.driver", "C:\\\\Drivers\\\\edgedriver_win64\\\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
	//	WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText() , "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container']  h2")).getText(), "Hello "+name+",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
        }
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String passwordText=driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText();
		String [] passwordArray = passwordText.split("'");
		String Password = passwordArray[1].split("'")[0];
		return Password;
		
	}
	}
	


