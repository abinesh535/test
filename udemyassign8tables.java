package exercise;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class udemyassign8tables {
	@Test
	public void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement table = driver.findElement(By.id("product")); //focus specific table
		System.out.println(table.findElements(By.tagName("tr")).size());  //in table finding all tr
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size()); //in entire tr, finding 1st tr and in 1st tr finding th
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));  //in entire tr, finding 2nd tr and in 2nd tr finding td
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
	}
}
