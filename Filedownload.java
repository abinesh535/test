package documenttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
import java.io.*;

public class Filedownload {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		String filedownload=System.getProperty("user.dir");
		chromePrefs.put("download.default_directory", filedownload);
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='sample.pdf']")).click();
		
		File f=new File(filedownload+"\\sample.pdf");
		Thread.sleep(5000);
		
		if(f.exists()) {
			System.out.println("File downloaded successfully");
		}else {
			System.out.println("File not found");
		}

	}

}
