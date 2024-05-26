package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	
	public static void main(String[] args) throws IOException {
		readAllData();
	}
	
	public static void readAllData() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Nexus Lite\\eclipse-workspace\\nexus-ui\\src\\test\\resources\\testdata\\data.xlsx");
		
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		
		
		int row = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0;i<row;i++) {
			
			for(int j=0;j<column;j++) {
				
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value);
				System.out.print(" | ");
				
			}
			System.out.println();
		}
	}
}
