package testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class Administer_Med {
    @Test
	@SuppressWarnings("deprecation")
	public  static void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
    	WebDriver driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://192.168.1.24/workingzadmin/UI/Common/Access_Login.aspx");
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kadmin");
	    driver.findElement(By.xpath("//button[@id='SALogIn_btn_LogIn']")).click();
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");
	    driver.findElement(By.xpath("//button[@id='SALogIn_btn_LogIn_SSO']")).click();
        Thread.sleep(4000);
	    driver.findElement(By.xpath("//input[@id='MainContent_txt_HHAName']")).sendKeys("1");
        Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
		Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@title='Login to Medicare as Support ']//child::img")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Set<String> allhandles= driver.getWindowHandles();
		List<String> list=new ArrayList<String>(allhandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//*[@id='15']")).click();
		driver.findElement(By.xpath("//*[@id='td_2']")).click();
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys("MEDICATION, AUSTIN (245)"); 
		driver.findElement(By.xpath("//input[@id='MainContent_btn_Search']")).click();
        Thread.sleep(3000);	
        driver.findElement(By.xpath("//a[@title='Click here to view Client Profile']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//td[@id='tab_3']")).click();
		driver.findElement(By.xpath("//select[@id=\"ddlCertificationPeriod\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ddlCertificationPeriod\"]/option[1]")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement scroll=driver.findElement(By.xpath("//*[@id=\"td_Schedule_EchartLink_ 5633454\"]/a"));
		je.executeScript("arguments[0].scrollIntoView(true);",scroll);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		scroll.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Set<String> allhandles1= driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(allhandles1);
		driver.switchTo().window(list1.get(2));
		driver.findElement(By.xpath("//*[text()='Medications']//parent::span[@class='rtsIn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"btn_EditTask\"]")).click();
		Set<String> allhandles2= driver.getWindowHandles();
		List<String> list2=new ArrayList<String>(allhandles2);
		driver.switchTo().window(list2.get(3));
		driver.findElement(By.xpath("//input[@id=\"chkMedication0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"drplst_MedicationGivenBy_0_0\"]/option[1]")).click();
        driver.findElement(By.xpath("//input[@id=\"txttime0_0\"]")).sendKeys("4:00");
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"chkMedication0\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    
	}
}
