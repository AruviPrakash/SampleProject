package week4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws Exception, IOException {
		
		XSSFWorkbook wbook = new XSSFWorkbook();
		
		XSSFSheet sheet = wbook.createSheet("Output");
		XSSFRow row = sheet.createRow(0);
		XSSFRow row1 = sheet.createRow(1);
		XSSFRow row2 = sheet.createRow(2);
		XSSFRow row3 = sheet.createRow(3);
		XSSFRow row4 = sheet.createRow(4);
		
		row.createCell(0).setCellValue("SerialNo");
		row.createCell(1).setCellValue("TestCase");
		row.createCell(2).setCellValue("Result");
		row1.createCell(1).setCellValue("Create");
		row2.createCell(1).setCellValue("Edit");
		row3.createCell(1).setCellValue("Delete");
		row4.createCell(1).setCellValue("Merge");
		
		int i;
		
		for(i=1;i<=4;i++)
		{
			sheet.getRow(i).createCell(0).setCellValue(i);
			
			if(i%2==0)
			{
				sheet.getRow(i).createCell(2).setCellValue("Fail");
			}
			else
			{
				sheet.getRow(i).createCell(2).setCellValue("Pass");
			}
		}
		
		FileOutputStream file = new FileOutputStream(new File("./data/sample1.xlsx"));
		wbook.write(file);
		wbook.close();
		
	}

}
