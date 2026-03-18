import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;

public class Greenkart{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		int j=0;
		String[] neededname = {"Cucumber", "Brocolli", "Beetroot","Carrot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(int i=0;i<products.size();i++) {
			String[] name=products.get(i).getText().split("-");
			String latestname = name[0].trim();
			List latestnameList = Arrays.asList(neededname);
			if(latestnameList.contains(latestname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==neededname.length) {
					break;
				}
			}
			
		}
		
	}
}