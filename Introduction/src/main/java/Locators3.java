import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Locators3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver.exe","C:\\\\Drivers\\\\edgedriver_win64\\\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		driver.close();
	}
	

}
