package data;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel {

	public static void main(String[] args) throws IOException {
		
	
		
		 try (HSSFWorkbook wb = new  HSSFWorkbook()) {
			HSSFSheet sheet=wb.createSheet("test");
			 sheet.createRow(0);
			 sheet.getRow(0).createCell(0).setCellValue("Hi");
			 
			 File file=new File("C:\\Users\\abineshg\\Desktop\\My\\Language\\selenium\\test.xls");
			 wb.write(file);
		}
		 
	}

}
