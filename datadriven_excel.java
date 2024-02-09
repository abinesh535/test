package datadriven3;

import java.util.Arrays;
import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class datadriven_excel {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abineshg\\Desktop\\My\\Drivers\\chromedriver116.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://devlocal.kantimehealth.net/identity/v2/Accounts/Authorize?product=hh_admin&state=");
		Thread.sleep(2000);

		File src = new File("C:\\Users\\abineshg\\Desktop\\My\\Drivers\\datadriven_selenium.xls"); // Import excel																								
		FileInputStream finput = new FileInputStream(src); // Load the file.
		HSSFWorkbook workbook = new HSSFWorkbook(finput); // Load the workbook.
		HSSFSheet sheet = workbook.getSheet("Sheet1"); // Load the sheet in which data is stored.
		int rows = sheet.getLastRowNum();
		for (int i = 1; i <= rows; i++) {
			HSSFCell Cell = sheet.getRow(i).getCell(0);
			DataFormatter formatter = new DataFormatter();
			String username = formatter.formatCellValue(Cell);
			Cell = sheet.getRow(i).getCell(1);
			String password = formatter.formatCellValue(Cell);
			driver.findElement(By.id("txt_username")).clear();
			driver.findElement(By.id("txt_username")).sendKeys(username);
			driver.findElement(By.id("txt_password")).clear();
			driver.findElement(By.id("txt_password")).sendKeys(password);
			System.out.print(username);
			System.out.print(" " + password);
			System.out.println();
			Thread.sleep(2000);
		}
	}
}
