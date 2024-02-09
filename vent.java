package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;

public class vent {
@Test
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver2.exe");
    	ChromeOptions options=new ChromeOptions();
    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://192.168.1.24/workingzadmin/UI/Common/Access_Login.aspx");
	    driver.findElement(By.xpath("//input[@id='txt_username']")).sendKeys("kadmin");
	    driver.findElement(By.xpath("//input[@id='txt_password']")).sendKeys("demo");
	    driver.findElement(By.xpath("//button[@id='btn_login']")).click();
		driver.findElement(By.xpath("//input[@id='MainContent_txt_HHAName']")).sendKeys("901246");
        Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@title='Login to Medicare as Support ']//child::img")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> allhandles= driver.getWindowHandles();
		List<String> list=new ArrayList<String>(allhandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//*[@id='15']")).click();
		driver.findElement(By.xpath("//*[@id='td_2']")).click();
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys("AUSTIN, IMPLICIT (1302)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='MainContent_btn_Search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Click here to view Client Profile']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@id='tab_4']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[@class='KT_btn'])[2]")).click();
		driver.findElement(By.xpath("(//*[normalize-space(text())='Ventilator Order'])[3]")).click();
		Set<String> allhandles1= driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(allhandles1);
		driver.switchTo().window(list1.get(2));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='Chk_VerbalOrder']")).click();
		driver.findElement(By.xpath("//input[@id='txtOrderDate']")).sendKeys("11/18/2022");
		Select staff=new Select(driver.findElement(By.xpath("//select[@id='ddl_clinician']")));
		int dropdown=driver.findElements(By.xpath("//select[@id='ddl_clinician']//child::option")).size();
		System.out.println(dropdown);
		Random staffdrop=new Random();
		int index=staffdrop.nextInt(dropdown);
		staff.selectByIndex(index);
		driver.findElement(By.xpath("//input[@id='txt_Eff_orderDate']")).sendKeys("11/20/2022");
		driver.findElement(By.xpath("//*[@id=\"ddlShiftname_0\"]/option[4]")).click();
		//driver.findElement(By.xpath("//select[@id='ddl_FormVersion']//child::option[text()='Ventilator Flow Sheet 374']")).click();
		//driver.findElement(By.xpath("//select[@id='txt_Mode']//child::option[text()='Assist Control']")).click();
		driver.findElement(By.xpath("//input[@id='CHKSignature2']")).click();
		driver.findElement(By.xpath("//input[@id='btnAddModify']")).click();
		//driver.findElement(By.xpath("//input[@id='id_Ok']")).click();
		
	}

}
