package opentapshw;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.testng.annotations.AfterClass;

public class OpenTapsWrapper extends Wrapper{
  
	
  @BeforeMethod(groups={"smoke","sanity"})
  public void beforeMethod() {
	  System.out.println("login");
	  System.out.println("click crm");
	  System.out.println("click lead");
  }


  @BeforeClass(groups={"smoke","sanity"} )
  public void beforeClass(String browser) {
	
	//LaunchApp(Browser,URL );
	  System.out.println("lanch browers"+browser);
  }

  @AfterClass(groups={"smoke","sanity"})
  public void afterClass() {
	  closeBrowser();
	  System.out.println("close brower");
  }
  
  @Test(dataProvider="mydata")
  public void sample(String Companyname){
	  System.out.println("mmmmmm");
	  System.out.println("sample" +Companyname);
  }
  
  public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream myfile = new  FileInputStream(new File ("./data/Opentaps.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(myfile); 
			XSSFSheet sheet =  workbook.getSheetAt(0);
			XSSFRow row  = sheet.getRow(0);
			
			int totalNoOfRows = rowcount();
			
			int totalNoOfCols= sheet.getRow(totalNoOfRows).getLastCellNum();
			 //= sheet.getColumns();
			
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} //catch (BiffException e) {
			//e.printStackTrace();
		//}
		return arrayExcelData;

}
  
   
  @DataProvider(name="mydata")
	public Object[][] getdata()  {
		String [][] data = getExcelData("./data/Opentaps.xlsx","Sheet1");
		
				
		String ComapanyName= data[1][4];
		System.out.println("sample");
		System.out.println(ComapanyName);
		/*String Firstname = currentrow.getCell(5).getStringCellValue();
		String Lastname = currentrow.getCell(6).getStringCellValue();
		int Source = (int) currentrow.getCell(7).getNumericCellValue();
		int MarketingID = (int) currentrow.getCell(8).getNumericCellValue();
		String PhoneNo = currentrow.getCell(9).getStringCellValue();
		String Email = currentrow.getCell(10).getStringCellValue();*/
		return data;
}
}
