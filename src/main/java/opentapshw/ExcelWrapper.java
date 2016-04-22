package opentapshw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrapper {
	
	public XSSFWorkbook workbook =null;
	public XSSFSheet sheet = null;
		
	public void openwbook(String Filepath, String Sheetname) throws IOException 
	{
		try {
			FileInputStream myfile = new  FileInputStream(new File (Filepath));
			workbook = new XSSFWorkbook(myfile); 
			sheet =  workbook.getSheet(Sheetname);
			} 
		catch (FileNotFoundException e) {
			System.out.println("Excel workbook not found");
			}
	}

	public int rowcount()
	{
		int i= 0;
		try {
			 i =sheet.getLastRowNum();
			} 
		catch (Exception e) 
			{
			System.out.println("No rows present");
			}
		return i;

	}
	
	public String CellValue(int rowNo, int columnNo) 
	{	
		String val = null;
		try {
			val= sheet.getRow(rowNo).getCell(columnNo).getStringCellValue();
			}
		catch (Exception e)
			{
			System.out.println("cell is empty");
			}
		return val;
	}
	
	public void writewbook(int rowNo, int columnNo,String data,String path) throws IOException
	{
		FileOutputStream file =null;
		try {
			sheet.getRow(rowNo).createCell(columnNo).setCellValue(data);
			file = new FileOutputStream(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("data not updated in excel");
		}
		workbook.write(file);
	}
	
	public void closewbook()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			System.out.println("workbooknot open");
		}
	}
}
