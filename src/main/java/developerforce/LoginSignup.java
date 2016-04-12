package developerforce;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginSignup {

	public static void main(String[] args) {
		
		//Launch browser
		FirefoxDriver browser;
		browser =  new FirefoxDriver();
		
		//Open Developerforce page
		browser.get("https://developer.salesforce.com/");
		
		//To Maximize
		browser.manage().window().maximize();
		
		//browser.findElementByClassName("mobile mobileHeader").click();
		//ToSignup
		browser.findElementByXPath("/html/body/div[3]/header/div/div/div/div[1]/div[1]/div[1]/a").click();
		
		//Verify page
		System.out.println(browser.getTitle());
		
		//Registration page
		//Enter first name
		browser.findElementById("first_name").sendKeys("Prakash");
		
		//Enter first name
		browser.findElementById("last_name").sendKeys("Karthik");
		
		//Enter Email
		browser.findElementByName("user[email]").sendKeys("prakash@gmail.com");
		
		//SelectRole
		Select clickone = new Select(browser.findElementById("job_role"));
		//clickone.deselectAll();
		clickone.selectByVisibleText("Administrator");
		
		//Enter Company
		browser.findElementByName("user[company]").sendKeys("PK Enterprises");
				
		//Select country
		//clickone.deselectAll();
		//clickone.selectByVisibleText("IN");
		browser.findElementById("country").sendKeys("India");
		
		//Enter Postalcode
		browser.findElementByName("user[postal_code]").sendKeys("600005");
		
		//Enter Username
		browser.findElementByName("user[username]").sendKeys("prakash@pkenterprises.com");
		
		//Select read and agree checkbox
		browser.findElementById("eula").click();
		
		//click Sign me up
		//browser.findElementById("submit_btn").click();
		
		//Clickgettingstarted
		//browser.findElementByLinkText("/gettingstarted");
		
		//Open Developerforce page
		browser.get("https://developer.salesforce.com/");
		
		//Click Login
		browser.findElementById("login-button").click();
		
		//EnterUsername
		browser.findElementById("username").sendKeys("prakash@pkenterprises.com");
		
		//Enterpassword
		browser.findElementById("password").sendKeys("waterfalld");
		
		//click  Login
		browser.findElementByXPath("//*[@id=\"Login\"]").click();
		
		//close the browser
		browser.close();
	}

}
