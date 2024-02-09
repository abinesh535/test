package cal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calender {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1000)");
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		String month= driver.findElement(By.className("ui-datepicker-month")).getText();
		String year=driver.findElement(By.className("ui-datepicker-year")).getText();
		Thread.sleep(5000);
		
		while(!(month.equals("January") && (year.equals("2024")))) {
			
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		    month= driver.findElement(By.className("ui-datepicker-month")).getText();
			year=driver.findElement(By.className("ui-datepicker-year")).getText();	
		}
		WebElement selectedDMY=driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='10']"));
		selectedDMY.click();
		Thread.sleep(2000);
		String Entereddate=driver.findElement(By.id("first_date_picker")).getText();
		System.out.println("print"+ Entereddate);

	}

}
