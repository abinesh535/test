package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ADR {
@Test
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver1.exe");
    	ChromeOptions options=new ChromeOptions();
    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://192.168.1.24/workingzadmin/UI/Common/Access_Login.aspx");
	    driver.findElement(By.xpath("//input[@id='txt_username']")).sendKeys("kadmin");
	    driver.findElement(By.xpath("//input[@id='txt_password']")).click();
	    driver.findElement(By.xpath("//input[@id='txt_password']")).sendKeys("demo");
	    driver.findElement(By.xpath("//button[@id='btn_login']")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"RowID0\"]/td[16]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Set<String> allhandles= driver.getWindowHandles();
		List<String> list=new ArrayList<String>(allhandles);
		driver.switchTo().window(list.get(1));
	    driver.findElement(By.xpath("//*[@id=\"66\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"td_0\"]/table/tbody/tr/td[1]")).click();
	    driver.findElement(By.xpath("//*[@id=\"td_sub1\"]")).click();
	    driver.findElement(By.xpath("//input[@value='Display']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement scroll=driver.findElement(By.xpath("(//img[@title='Manage ADR Documents'])[1]"));
		je.executeScript("arguments[0].scrollIntoView(true);",scroll);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		scroll.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Set<String> allhandles1= driver.getWindowHandles();
        List<String> list1=new ArrayList<String>(allhandles1);
     	System.out.println(list1);
     	driver.switchTo().window(list1.get(2));
     	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     	driver.findElement(By.xpath("//input[@name=\"Records1\"]/following::span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"orderTab\"]")).click();
     	driver.findElement(By.xpath("//input[@id=\"Tab9\"]//following::span[1]")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='btn_GeneratePDF']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id=\"btn_Verify\"]")).click();
        Thread.sleep(3000);
       // driver.findElement(By.xpath("//input[@id=\"chk_ConfirmDocVerify\"]//following::span")).click();
       // driver.findElement(By.xpath("//input[@id=\"btn_VerifyDoc\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"btn_CLose_Verify\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"closeManageAdr\"]")).click();

	}

}
