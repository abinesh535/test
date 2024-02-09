package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class RCD {
    @SuppressWarnings("deprecation")
	@Test
	public static void main() throws InterruptedException {
 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		ChromeOptions launch=new ChromeOptions();
		launch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		launch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		launch.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		WebDriver driver=new ChromeDriver(launch);
		driver.manage().window().maximize();
		driver.get("https://192.168.1.24/workingzadmin/UI/Common/Access_Login.aspx");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kadmin");
		driver.findElement(By.xpath("//button[@id='SALogIn_btn_LogIn']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@id='SALogIn_btn_LogIn_SSO']")).click();
	    Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='MainContent_txt_HHAName']")).sendKeys("276");
	    Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		Thread.sleep(4000);
	    driver.findElement(By.xpath("//a[@title='Login to Medicare as Support ']//child::img")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> allhandles= driver.getWindowHandles();
		List<String> list=new ArrayList<String>(allhandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//*[@id=\"66\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"td_10\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"td_sub0\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"btnDisplay\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"RowID\"]/td[14]/table/tbody/tr/td[1]/a/img")).click();
		Set<String> allhandles1= driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(allhandles1);
		driver.switchTo().window(list1.get(2));
		driver.findElement(By.xpath("//*[@id=\"CHk_Confirm\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Btn_SaveDocument\"]")).click();
		
	}

}
