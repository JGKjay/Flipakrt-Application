package Utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;






public class Utility { 
	public static String getStringFromSheet( int row , int col) {
	 String data;
	 
	 String path = "E:\\Automation class 2\\excelsheet\\Demo.xlsx";
	 FileInputStream file = new FileInputStream(path);
		Sheet s = WorkbookFactory.create(file).getSheet("Demo");
		
		try 
		{
		 data = s.getRow(row).getCell(col).getStringCellValue();
		 
		}
		catch(IllegalStateException e) {
			
			double value = s.getRow(1).getCell(1).getNumericCellValue();
			
			data = value.toString();
			
		}
		catch(NullPointerException e){
			System.out.println("Cell is blank");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 
	 
	 return data;
	 
	}

}
