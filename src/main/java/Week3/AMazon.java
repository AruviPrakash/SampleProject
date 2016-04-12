package Week3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AMazon {

	public static void main(String[] args) throws IOException, Exception {
		
		//CHromedriver
				System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
				
				ChromeDriver driver =new ChromeDriver();
				
				//Opens Webpage
				driver.get("http://www.amazon.in/");
				Thread.sleep(5000);
				
				FileInputStream myfile = new  FileInputStream(new File ("./data/amazon.xls"));
				
				HSSFWorkbook workbook = new HSSFWorkbook(myfile); 
				
				HSSFSheet sheet =  workbook.getSheetAt(0);
				
				HSSFRow currentrow = sheet.getRow(1);
				
				String input1 = currentrow.getCell(0).getStringCellValue();
				String input2 =currentrow.getCell(1).getStringCellValue();
				
				driver.findElementByXPath("//input[@id = 'twotabsearchtextbox']").sendKeys(input1);
				
				driver.findElementByXPath("//input[@class= 'nav-input']").click();
				
				WebElement a = driver.findElementByXPath("(//h2[@class = 'a-size-medium a-color-null s-inline  s-access-title a-text-normal'])["+input2+"]");
				
				System.out.println("The 3rd items title " +a.getText());	
				}

	}


