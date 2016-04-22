package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erailnew extends Wrapper {
	
	@Test
	
	public void login() throws IOException {
		
		LaunchApp("chrome", "http://erail.in/");
		driver.findElementById("txtStationFrom").sendKeys("MAS",Keys.TAB);
		driver.findElementById("txtStationTo").sendKeys("ERS",Keys.TAB);
		
		WebElement traintable = driver.findElementByClassName("DataTable TrainList");
				//(By.className("DataTable DataTableHeader TrainList"));
		List<WebElement> allrows =  traintable.findElements(By.tagName("tr"));
		int rows= allrows.size();
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet sheet = wbook.createSheet("webtable");
		
		System.out.println(rows);
		for (int i=0;i<=rows;i++)
			
		{
			XSSFRow row = sheet.createRow(i);
			List<WebElement> allcolumns =  traintable.findElements(By.tagName("td"));
			int columns = allcolumns.size();
			System.out.println(columns);
			for (int j=0;j<=columns;j++)
			{
				WebElement value= allcolumns.get(j);
				String cellvalue= value.getText();
				sheet.getRow(i).createCell(j).setCellValue(cellvalue);
				
			}
		}
		FileOutputStream file = new FileOutputStream(new File("./data/sampletrain.xlsx"));
		wbook.write(file);
		
		
		
		
		
		
		
		
		
		
		wbook.close();
		
		

}
}
