package exercise;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class udemyassign7 {
@Test
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1000)");
		Thread.sleep(3000);
		WebElement date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
		date.click();
		while (!driver.findElement(By.cssSelector("[class='flatpickr-month']")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector("[class='flatpickr-month']  [class='flatpickr-next-month']")).click();
		}
		@SuppressWarnings("unused")
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
//Grab common attribute//Put into list and iterate
		int count = driver.findElements(By.className("flatpickr-day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
	}
}