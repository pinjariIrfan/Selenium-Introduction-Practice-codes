import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UpdatedDropdownDomAttribute {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		
if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"))
{
	System.out.println("its enabled");
	Assert.assertTrue(true);
}
else {
	Assert.assertTrue(false);
}		
		
		
	}

}
