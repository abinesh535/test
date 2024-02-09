package exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class udemyassign1 {
@Test
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
       System.out.println( driver.findElements(By.cssSelector("input[type='checkbox']")).size());
}

}
