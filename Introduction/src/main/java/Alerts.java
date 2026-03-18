import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Alerts {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		String name = "Rahul";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#name")).sendKeys(name);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector("#name")).sendKeys(name);
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.close();
		
	}

}
