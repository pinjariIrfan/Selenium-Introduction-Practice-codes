import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class E2Espicejet{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0"));
		Thread.sleep(3000);
		if(driver.findElement(By.cssSelector("#Div1")).getDomAttribute("style").contains("0.5")){
			Assert.assertTrue(true);
			}
		else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']  //a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='MAA']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i=1; i<5; i++) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();	
		}
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		
	}
}