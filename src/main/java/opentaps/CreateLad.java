package opentaps;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateLad {

	public static void main(String[] args) {
		//Launch Browser
				FirefoxDriver driver= new FirefoxDriver();
				
				//Navigate to URL
				driver.get("http://demo1.opentaps.org/");
				
				//Maximize browser
				driver.manage().window().maximize();
				
				
				//Display title
				System.out.print("Login Page  Title :");
				System.out.println(driver.getTitle());
				
				//Enter USername
				driver.findElementById("username").sendKeys("DemoSalesManager");
				
				//Enter PAssword
				driver.findElementByName("PASSWORD").sendKeys("crmsfa");
				
				//Click LOgin
				driver.findElementByClassName("decorativeSubmit").click();
				
				//Display title
				System.out.print("Page title after Login");
				System.out.println(driver.getTitle());
				
				//Click CRM/SFAimage
				driver.findElementByXPath("//*[@id=\"label\"]/a").click();
								
				//Click CreateLEad
				driver.findElement(By.cssSelector("a[href*='createLeadForm']")).click();

				//TO Create Lead
				//Enter COmpanyName
				driver.findElementById("createLeadForm_companyName").sendKeys("PK ENterprises");
				
				//EnterFirstname
				driver.findElementById("createLeadForm_firstName").sendKeys("Prakash");
				
				//EnterLAstname
				driver.findElementById("createLeadForm_lastName").sendKeys("LName");
				
				//click create lead
				driver.findElementByName("submitButton").click();
				
				//DIsplayTitle
				System.out.print("Page Title After Creating Lead:");
				System.out.println(driver.getTitle());
				
				System.out.print("Page Header After Creating Lead:");
				System.out.println(driver.findElementById("sectionHeaderTitle_leads").getText());
				
				//click logout
				driver.findElement(By.cssSelector("a[href*='logout']")).click();
				
				//close the browser
				driver.close();

	}

}
