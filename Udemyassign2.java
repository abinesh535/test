package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Udemyassign2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("*[class=\"form-control ng-untouched ng-pristine ng-invalid\"]")).sendKeys("abinesh");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234567");
		driver.findElement(By.xpath("//*[@id=\"exampleFormControlSelect1\"]/option[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"inlineRadio1\"]")).click();
		driver.findElement(By.xpath("//*[@name=\"bday\"]")).sendKeys("10-01-1996");
		driver.findElement(By.cssSelector("*[class=\"btn btn-success\"]")).click();
		System.out.println(driver.findElement(By.cssSelector("*[class=\"alert alert-success alert-dismissible\"]")).getText());
	}

}
