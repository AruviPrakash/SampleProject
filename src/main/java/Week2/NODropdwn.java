//HW 5 Find the number of drop down fields 

package Week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NODropdwn {

	public static void main(String[] args) throws InterruptedException {
		
		//CHromedriver
				System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
				
				ChromeDriver driver =new ChromeDriver();
					
				//Navigate to URL
				driver.get("https://www.irctc.co.in/");
				Thread.sleep(5000);
				
				//Display title
				System.out.print("Page  Title :");
				System.out.println(driver.getTitle());
				
				//Click Signup
				driver.findElementByLinkText("Sign up").click();

				//Display title
				System.out.print("Registration Page  Title :");
				System.out.println(driver.getTitle());
				
				//FInd the dropdowns
				List<WebElement>  count = driver.findElementsByTagName("select");
				//Display thecount ofdropdowns in the page
				System.out.println("The number of drop downs are :" +count.size());
				
				driver.close();
				
	}

}
