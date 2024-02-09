package driventest;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class add_data_to_excel {
		
		@SuppressWarnings({ "unused", "resource" })
		public static void main1(String[] args) throws IOException {
					
			HSSFWorkbook wb=new HSSFWorkbook();
            HSSFSheet sheet=wb.createSheet("test");
            
            File file = new File("C:\\Users\\abineshg\\Downloads\\selenium datadriven.xls");
			wb.write(file);
		
	}}


