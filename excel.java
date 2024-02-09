package driventest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel {
		
	//DataFormatter formatter = new DataFormatter();
		public Object[][] main1(String[] args) throws IOException {

			FileInputStream fis = new FileInputStream("C:\\Users\\abineshg\\Downloads\\selenium datadriven.xls"); // add excel path
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheetAt(0);
			int rowcount = sheet.getPhysicalNumberOfRows();
			HSSFRow row = sheet.getRow(0);
			int colcount =row.getLastCellNum();
			Object data[][] = new Object[rowcount-1][colcount];
			for(int i=0; i<rowcount-1; i++) {
				
				System.out.println(row.getCell(i));
				row = sheet.getRow(i + 1);
				for(int j=0; j<colcount; j++) {
					
					System.out.println(row.getCell(j));
			
					HSSFCell cell = row.getCell(j);
					//data[i][j] = formatter.formatCellValue(cell);

				}
			}
			return data;
		}

		public static void main(String[] args) {
		}
	
	}


