package textbox;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Googlepage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver116.exe");
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        options.addArguments("--remote-allow-origins=*");
        driver.get("https://www.google.com/");
        WebElement keyboard= driver.findElement(By.xpath("//*[@title='Search']"));
        keyboard.sendKeys("asian games medal tally 2023");
        keyboard.sendKeys(Keys.ENTER);
        
	}

}
