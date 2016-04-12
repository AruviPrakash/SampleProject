package wrapper;

import org.junit.Test;

public class OpenTapsCL extends Wrapper{
	
	
	@Test
	
	public void login() {
		// Login Open Taps and CreateLead
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
		Click("name", "submitButton");
		VerifyTitle("View Lead | opentaps CRM");
		VerifyTxt("View Lead", "sectionHeaderTitle_leads");
		Click("linkText", "Contacts");
		Click("linkText", "Create Contact");
		EntertextValue("id", "firstNameField", "ContactFname");
		EntertextValue("id", "lastNameField", "Contactlname");
		Click("name", "submitButton");
		VerifyTitle("View Contact | opentaps CRM");
		VerifyTxt("View Contact", "sectionHeaderTitle_contacts");
		Click("cssSelector", "a[href*='logout']");
	}

	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


