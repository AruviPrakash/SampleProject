package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class OpenTapsCL extends Wrapper{
	
	
	@Test
	
	public void login() throws IOException {
		// Login Open Taps and CreateLead
		FileInputStream myfile = new  FileInputStream(new File ("./data/Opentaps.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(myfile); 
		XSSFSheet sheet =  workbook.getSheetAt(0);
		XSSFRow currentrow = sheet.getRow(1);
		
		String input1 = currentrow.getCell(0).getStringCellValue();
		String input2 =currentrow.getCell(1).getStringCellValue();
		
		
		
		LaunchApp("chrome","http://demo1.opentaps.org/opentaps/control/main" );
		EntertextValue("id", "username", "DemoSalesManager");
		EntertextValue("name", "PASSWORD", "crmsfa");
		Click("className", "decorativeSubmit");
		VerifyTitle("Opentaps Open Source ERP + CRM");
		Click("xpath", "//*[@id=\"label\"]/a");
		
		Click("cssSelector", "a[href*='createLeadForm']");
		EntertextValue("id", "createLeadForm_companyName", "PK ENterprises");
		EntertextValue("id", "createLeadForm_firstName", "Prakash");
		EntertextValue("id", "createLeadForm_lastName", "Lname");
		selectValueByIndex(1, "id", "createLeadForm_dataSourceId");
		selectValueByIndex(3, "id", "createLeadForm_marketingCampaignId");
		EntertextValue("id", "createLeadForm_primaryPhoneNumber", "32654789");
		EntertextValue("id", "createLeadForm_primaryEmail", "buddy@gmail.com");
		Click("name", "submitButton");
		Capturetext("id", "viewLead_companyName_sp");
		
		VerifyTitle("View Lead | opentaps CRM");
		VerifyTxt("View Lead", "sectionHeaderTitle_leads");
		
		
		Click("linkText", "Contacts");
		Click("linkText", "Create Contact");
		EntertextValue("id", "firstNameField", "ContactFname");
		EntertextValue("id", "lastNameField", "Contactlname");
		Click("name", "submitButton");
		VerifyTitle("View Contact | opentaps CRM");
		VerifyTxt("View Contact", "sectionHeaderTitle_contacts");
		//Click("cssSelector", "a[href*='logout']");
	}

	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


