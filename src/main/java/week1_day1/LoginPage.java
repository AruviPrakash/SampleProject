package week1_day1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	public static void main(String[] args) {
		
		//Launch Browser
		FirefoxDriver driver= new FirefoxDriver();
		
		//Navigate to URL
		driver.get("http://demo1.opentaps.org/");
		
		//Display title
		System.out.println(driver.getTitle());
		
		//Enter USername
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Enter PAssword
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		
		//Click LOgin
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Display title
		System.out.println(driver.getTitle());
		
		//clicklogout
		driver.findElementByClassName("decorativeSubmit").click();
		
		//close the browser
		//driver.close();
		
		//driver.findElementByXPath("//*[@id=/"form/"]/h2").getText		
	}

}
