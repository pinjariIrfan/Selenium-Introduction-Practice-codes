import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class WindowActivities {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back();
		driver.navigate().forward();
		// TODO Auto-generated method stub

	}

}
