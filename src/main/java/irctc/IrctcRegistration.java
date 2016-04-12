package irctc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcRegistration {

	public static void main(String[] args) throws InterruptedException  {
		//Launch Browser
		FirefoxDriver driver= new FirefoxDriver();
		
		//Navigate to URL
		driver.get("https://www.irctc.co.in/");
		
		//Maximize browser
		driver.manage().window().maximize();
		
		
		//Display title
		System.out.print("Page  Title :");
		System.out.println(driver.getTitle());
		
		//Click Signup
		driver.findElementByLinkText("Sign up").click();

		//Display title
		System.out.print("Registration Page  Title :");
		System.out.println(driver.getTitle());
		
		System.out.print("Page Header :");
		System.out.println(driver.findElementById("userRegistrationForm:j_idt152_header").getText());
		
		//ENter User ID
		driver.findElementByName("userRegistrationForm:userName").sendKeys("Mithuuser");
		
		//Enter  Password
		driver.findElementByName("userRegistrationForm:password").sendKeys("password55");
		
		//Enter Confirm Password
		driver.findElementByName("userRegistrationForm:confpasword").sendKeys("password55");
		
		//Select Security question
		driver.findElementByName("userRegistrationForm:securityQ").sendKeys("What is your favourite past-time?");
	
		//Enter security question answer
		driver.findElementByName("userRegistrationForm:securityAnswer").sendKeys("Browsing");
		
		//ENter Personaldetails
		driver.findElementByName("userRegistrationForm:firstName").sendKeys("Mithila");
		driver.findElementByName("userRegistrationForm:middleName").sendKeys("Sri");
		driver.findElementByName("userRegistrationForm:lastName").sendKeys("Sai");
		driver.findElementById("userRegistrationForm:gender:1").click();
		driver.findElementById("userRegistrationForm:maritalStatus:0").click();
		driver.findElementById("userRegistrationForm:dobDay").sendKeys("05");	
		driver.findElementById("userRegistrationForm:dobMonth").sendKeys("MAY");
		driver.findElementById("userRegistrationForm:dateOfBirth").sendKeys("1985");
		driver.findElementById("userRegistrationForm:occupation").sendKeys("Others");
		driver.findElementById("userRegistrationForm:uidno").sendKeys("1345656");
		driver.findElementById("userRegistrationForm:idno").sendKeys("55345656");
		driver.findElementById("userRegistrationForm:email").sendKeys("amithu@gmail.com");
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9877456522");
		driver.findElementById("userRegistrationForm:nationalityId").sendKeys("India");
		
		//ENter REsidential Address
		driver.findElementById("userRegistrationForm:address").sendKeys("No 52");
		driver.findElementById("userRegistrationForm:street").sendKeys("Street name");
		driver.findElementById("userRegistrationForm:area").sendKeys("Area name");
		driver.findElementById("userRegistrationForm:countries").sendKeys("India");
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600005",Keys.TAB);
		//driver.findElementById("userRegistrationForm:statesName").sendKeys("TamilNadu");
		Thread.sleep(5000);
		System.out.println("Please wait");
		
		
		driver.findElementById("userRegistrationForm:cityName").sendKeys("Chennai");
		driver.findElementById("userRegistrationForm:postofficeName").sendKeys("Chepauk S.O");
		driver.findElementById("userRegistrationForm:resAndOff:0").click();
	}

	
}
