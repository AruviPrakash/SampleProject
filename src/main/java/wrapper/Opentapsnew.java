package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Opentapsnew extends Wrapper{
	
	
	@Test
	
	public void login() throws IOException {
		// Login Open Taps and CreateLead
		FileInputStream myfile = new  FileInputStream(new File ("./data/Opentaps.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(myfile); 
		XSSFSheet sheet =  workbook.getSheetAt(0);
		XSSFRow row  = sheet.getRow(0);
		
		int i;
		
		for(i=1;i<=2;i++)
		{
		XSSFRow currentrow = sheet.getRow(i);
		
		String Browser = currentrow.getCell(0).getStringCellValue();
		String URL =currentrow.getCell(1).getStringCellValue();
		String Username = currentrow.getCell(2).getStringCellValue();
		String PASSWORD = currentrow.getCell(3).getStringCellValue();
		String ComapanyName = currentrow.getCell(4).getStringCellValue();
		String Firstname = currentrow.getCell(5).getStringCellValue();
		String Lastname = currentrow.getCell(6).getStringCellValue();
		int Source = (int) currentrow.getCell(7).getNumericCellValue();
		int MarketingID = (int) currentrow.getCell(8).getNumericCellValue();
		String PhoneNo = currentrow.getCell(9).getStringCellValue();
		String Email = currentrow.getCell(10).getStringCellValue();
		
		
		LaunchApp(Browser,URL );
		EntertextValue("id", "username", Username);
		EntertextValue("name", "PASSWORD", PASSWORD);
		Click("className", "decorativeSubmit");
		VerifyTitle("Opentaps Open Source ERP + CRM");
		Click("xpath", "//*[@id=\"label\"]/a");
		Click("cssSelector", "a[href*='createLeadForm']");
		
		EntertextValue("id", "createLeadForm_companyName", ComapanyName);
		EntertextValue("id", "createLeadForm_firstName", Firstname);
		EntertextValue("id", "createLeadForm_lastName", Lastname);
		selectValueByIndex(Source, "id", "createLeadForm_dataSourceId");
		selectValueByIndex(MarketingID, "id", "createLeadForm_marketingCampaignId");
		EntertextValue("id", "createLeadForm_primaryPhoneNumber", PhoneNo);
		EntertextValue("id", "createLeadForm_primaryEmail", Email);
		Click("name", "submitButton");
		String LeadId = Capturetext("id", "viewLead_companyName_sp");
		VerifyTitle("View Lead | opentaps CRM");
		VerifyTxt("View Lead", "sectionHeaderTitle_leads");
		
		sheet.getRow(i).createCell(11).setCellValue(LeadId);
		//  String Leadidnew = LeadId.replaceAll("[\\$,.]", "");
		String Leadidnew = LeadId.replaceAll("[\\D]", "");
		System.out.println(Leadidnew);
		sheet.getRow(i).createCell(12).setCellValue(Leadidnew);
		
		FileOutputStream file = new FileOutputStream(new File("./data/Opentaps.xlsx"));
		workbook.write(file);
		
		
		Click("linkText", "Find Leads");
		EntertextValue("xpath", "(//input[@name='firstName'])[3]",Firstname );
		Click("xpath", "(//button[@class='x-btn-text'])[7]");
		Click("linkText",Leadidnew );
		VerifyTitle("View Lead | opentaps CRM");
		Click("linkText", "Edit");
		selectValueByIndex(4, "id", "addDataSourceForm_dataSourceId");
		Click("xpath", "(//input[@name='submitButton'])[2]");
		selectValueByIndex(4, "id", "addMarketingCampaignForm_marketingCampaignId");
		Click("xpath", "(//input[@name='submitButton'])[3]");
		Click("xpath", "//input[@name='submitButton']");
		
		}
		
		workbook.close();
		
		
		
		closeBrowser();
	}

	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


