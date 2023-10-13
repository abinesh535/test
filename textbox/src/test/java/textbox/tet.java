package textbox;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class tet {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ultimateqa.com/filling-out-forms/");
		WebElement random=driver.findElement(By.id("et_pb_contact_name_0"));
		Random nran=new Random();
		int ranvalue=nran.nextInt(100);
		random.sendKeys("medication" + ranvalue);
		Thread.sleep(2000);
		String print=driver.findElement(By.id("et_pb_contact_name_0")).getAttribute("value");
		System.out.println("Entered Value: " + print);
		Thread.sleep(1000);
		driver.close();
	
	}
}
