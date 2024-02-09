package cal;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.cucumber.java.en.*;

public class cucm1 {
	WebDriver driver;

		@Given("open browser")
		public void open_browser()  {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver118.exe");
			ChromeOptions options=new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		    options.addArguments("--remote-allow-origins=*");
	        driver=new ChromeDriver(options); 
			driver.manage().window().maximize(); 
		}

		@Given("user is on login page")
		public void user_is_on_login_page() {
			driver.get("https://devlocal.kantimehealth.net/identity/v2/Accounts/Authorize?product=hh_admin&state=");
		}

		@When("enter password and username")
		public void enter_password_and_username() {
		    driver.findElement(By.xpath("//input[@id='txt_username']")).sendKeys("kadmin");
		    driver.findElement(By.xpath("//input[@id='txt_password']")).sendKeys("demo");	    
		}

		@And("click login button")
		public void click_login_button() {
			driver.findElement(By.xpath("//button[@id='btn_login']")).click();
		}

		@Then("user navigated to home page")
		public void user_navigated_to_home_page() throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='MainContent_txt_HHAName']")).sendKeys("901246");
	        Thread.sleep(4000);
		}
	}

