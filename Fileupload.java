package documenttest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fileupload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).sendKeys("C:\\Users\\abineshg\\Desktop\\test.pdf"); (or)
		
		//normal click not works sometimes for file upload so use this
		WebElement button=driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		Actions click=new Actions(driver);
		click.moveToElement(button).click().perform();
		
		//to copy file
		StringSelection ss=new StringSelection("C:\\Users\\abineshg\\Desktop\\test.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot file=new Robot();
		file.delay(2000);
		//to press ctrl v
		file.keyPress(KeyEvent.VK_CONTROL);
		file.keyPress(KeyEvent.VK_V);
		//to relese ctrl v
		file.keyRelease(KeyEvent.VK_CONTROL);
		file.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
		file.keyPress(KeyEvent.VK_ENTER);
		file.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("uploaded-files")));
	}

}
