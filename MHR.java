package testing;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class MHR {
    @Test
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
    	ChromeOptions options=new ChromeOptions();
    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://192.168.1.24/Working/UI/Common/Login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"txt_username\"]")).sendKeys("test@vivapeds.com");
		driver.findElement(By.xpath("//*[@id=\"txt_password\"]")).sendKeys("test12345");
		driver.findElement(By.xpath("//*[@id=\"btn_login\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"15\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"td_1\"]")).click();
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys("Man, Magic (FTW1702-PDN)");
		driver.findElement(By.xpath("//input[@id='MainContent_btn_Search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Click here to view Client Profile']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"tab_8\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"btnActions\"]")).click();
       
        String parentwindow = driver.getWindowHandle();
        System.out.println("parent window is" + parentwindow);
		
        driver.findElement(By.xpath("//*[@id=\"MainContent_tr_MedicationHistory\"]/td")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        Set<String> allhandles= driver.getWindowHandles();
            for(String child:allhandles) {
                System.out.println("all window is" + child);
                
                if(!parentwindow.equalsIgnoreCase(child)) {
            	driver.switchTo().window(child);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        		driver.findElement(By.xpath("//div[@id=\"div_prceedgateway\"]/span/input")).click();
                driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        		//driver.close();

            }}
		
		driver.switchTo().window(parentwindow);
		//driver.close();
		

	}

}
