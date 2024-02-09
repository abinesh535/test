package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;

public class careplan {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
           
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> allhandles= driver.getWindowHandles();
		List<String> list=new ArrayList<String>(allhandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//*[@id='15']")).click();
		driver.findElement(By.xpath("//*[@id='td_2']")).click();
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys("730"); //1173 for z9 test hha
		driver.findElement(By.xpath("//input[@id='MainContent_btn_Search']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Click here to view Client Profile']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@id='tab_7']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='btn_addGoal']")).click();
		Set<String> allhandles1= driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(allhandles1);
		driver.switchTo().window(list1.get(2));
		Select discipline=new Select(driver.findElement(By.xpath("//select[@id='ddlDiscipline']")));
		int dropdown=driver.findElements(By.xpath("//select[@id='ddlDiscipline']//child::option")).size();
		System.out.println(dropdown);
		Random disdrop=new Random();
		int index=disdrop.nextInt(dropdown);
		discipline.selectByIndex(index);
		Thread.sleep(4000);
		Select area=new Select(driver.findElement(By.xpath("//select[@id='ddlArea']")));
		int dropdown1=driver.findElements(By.xpath("//select[@id='ddlArea']//child::option")).size();
		System.out.println(dropdown1);
		Random areadrop=new Random();
		int index1=areadrop.nextInt(dropdown1);
		area.selectByIndex(index1);
		driver.findElement(By.xpath("//input[@id=\"chkGoals_STG0\"]")).click();
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.close();
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("//input[@id='btn_addGoal']")).click();
	}

}
