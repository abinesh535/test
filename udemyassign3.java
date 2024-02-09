package exercise;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class udemyassign3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/label[2]/span[2]")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		Thread.sleep(3000);
		driver.findElement(By.id("okayBtn")).click();
		//System.out.println(driver.switchTo().alert().getText());
		Select dropdown=new Select (driver.findElement(By.cssSelector("select.form-control")));
		dropdown.selectByVisibleText("Student");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-footer .btn-info")));
		Thread.sleep(30);
		List<WebElement> items=driver.findElements(By.cssSelector(".card-footer .btn-info"));
				for(int i=0; i<items.size();i++) {
					items.get(i).click();
	}
       driver.findElement(By.partialLinkText("Checkout")).click();
}}
