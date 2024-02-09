package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class udemyassign6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement text=driver.findElement(By.id("checkBoxOption3"));
		text.click();
		String store = text.getAttribute("value");
		driver.findElement(By.id("dropdown-class-example")).sendKeys(store);
		driver.findElement(By.id("name")).sendKeys(store);
		driver.findElement(By.id("alertbtn")).click();
		String compare=driver.switchTo().alert().getText(); 
		if(compare.contains(store))
		{
			System.out.println("Success");
		}
	}
}
