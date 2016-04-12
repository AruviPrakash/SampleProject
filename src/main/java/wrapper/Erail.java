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

public class Erail extends Wrapper {
	
	@Test
	
	public void login() throws IOException {
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		
		driver.findElementById("txtStationFrom").sendKeys("MAS",Keys.TAB);
		driver.findElementById("txtStationTo").sendKeys("ERS",Keys.TAB);
		//driver.findElementByXPath("//input[@title='Select Departure date for availability']");
		//LaunchApp("chrome","http://erail.in/" );
		//EntertextValue("id", "txtStationFrom", "MAS");
		//EntertextValue("id", "txtStationTo", "ERS");
		//EntertextValue("xpath", "//input[@title='Select Departure date for availability']", "");
		
		WebElement traintable = driver.findElement(By.id("divMain"));
		List<WebElement> allrows =  traintable.findElements(By.tagName("tr"));
		
		int rowsize = allrows.size();
		System.out.println(rowsize);
		
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet sheet = wbook.createSheet("webtable");
		XSSFRow row = sheet.createRow(0);
		
		 for (int i=0; i<rowsize; i++) 
		    {
		        WebElement webRow = allrows.get(i);
		        //Get all cell values in each row
		        List<WebElement> allCells = webRow.findElements(By.tagName("td"));
		        //System.out.println(allCells.size());

		        if(allCells.size() > 1)
		        {
		            XSSFRow excelRow = sheet.createRow(i);

		            for (int j=0; j<allCells.size(); j++) 
		            {
		                WebElement webCell = allCells.get(j);
		                String text = webCell.getText();
		                if(text.length()>2)
		                {
		                    Cell excelCell = excelRow.createCell(j);
		                    excelCell.setCellValue(webCell.getText());
		                }                   
		            }
		        }
		    }
		 	
		 FileOutputStream file = new FileOutputStream(new File("./data/sampletrain.xlsx"));
			wbook.write(file);
			wbook.close();

}
}
