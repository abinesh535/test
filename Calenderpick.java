package exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calenderpick {
	static WebDriver driver;
   @Test
	public static void main(String[] args) throws InterruptedException {
       
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
	       WebDriver driver = new ChromeDriver(options); 
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/datepicker/");
			 WebElement calender=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));  
			 driver.switchTo().frame(calender);
			 Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
			
			selectdate("11","November","2022");		
	}
   
   public static String[] getmonthyear(String monthyearvar) {
	   return monthyearvar.split(" ");
   }
   public static void selectdate(String exdate, String exmonth, String exyear) {
	   String monthyearvar=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText();
	while(!(getmonthyear(monthyearvar)[0].equals(exmonth)
			   &&
			   getmonthyear(monthyearvar)[1].equals(exyear))){
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
	}
	driver.findElement(By.xpath("//a[text()='"+exdate+"']")).click();
   }
}
