package testing;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Kpc {

	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver116.exe");
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	    options.addArguments("--remote-allow-origins=*");
    	WebDriver driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.get("https://kpc.kantimehealth.net/KPC/UI/Common/LoginPage.aspx");
		driver.findElement(By.id("Text_loginName")).sendKeys("agrant@kanrad.com");
		driver.findElement(By.id("Btn_login")).click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abineshkanrad8");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id=\"continue-as\"]/div[2]")).click();

	}

}
