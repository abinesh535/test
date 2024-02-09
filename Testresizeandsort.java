package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Testresizeandsort {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
	       WebDriver driver = new ChromeDriver(options); 
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/draggable/");
			driver.findElement(By.xpath("//a[@href=\"http://jqueryui.com/resizable/\"]")).click();
			  WebElement obj=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));  
			    driver.switchTo().frame(obj);
			WebElement resize1=  driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
	        Actions resize2=new Actions(driver);
	        resize2.dragAndDropBy(resize1, 150, 50).perform();
	        driver.switchTo().defaultContent();
	        driver.findElement(By.xpath("//a[@href=\"http://jqueryui.com/sortable/\"]")).click();
	        WebElement obj1=driver.findElement(By.xpath("//*[@class=\"demo-frame\"]"));  
		    driver.switchTo().frame(obj1);
	        WebElement sort1=driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
	        WebElement sort2=driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[2]"));
	          Actions sort3 = new Actions(driver);
	          sort3.moveToElement(sort2);
	          sort3.clickAndHold();
	          sort3.moveToElement(sort1);
	          sort3.release().perform();
	          
	          }

}
