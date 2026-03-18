import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GreenkartWaits {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		String[] nameneeded = {"Cucumber","Brocolli","Beetroot"};
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		addItems(driver, nameneeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		
	}
	
	public static void addItems(WebDriver driver, String[] nameneeded) {
		int j=0;
		List<WebElement>products=driver.findElements(By.xpath("//h4[@class='product-name']"));
		List latestnamelist = Arrays.asList(nameneeded);
		for(int i=0; i<products.size(); i++) {
			String[] name= products.get(i).getText().split("-");
			String latestname=name[0].trim();
			if(latestnamelist.contains(latestname)) {
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			j++;
			if(j==nameneeded.length) {
				break;
				}
			}
		}
	}
	

}
