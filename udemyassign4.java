package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class udemyassign4 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("a[href*='windows']")).click();
		Set<String> allhandles= driver.getWindowHandles();
		List<String> list=new ArrayList<String>(allhandles);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(list.get(0));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

	}

}