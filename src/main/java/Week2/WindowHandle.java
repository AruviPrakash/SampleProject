//hw 6 (Go to popuptest.com and click on Multi-PopUp Test #2 and close all the windows opened except the parent and then print the title of the parent window.
 

package Week2;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
		ChromeDriver driver  = new ChromeDriver();
		
		//Open url
		driver.get("http://www.popuptest.com/");
		
		Thread.sleep(3000);
		
		driver.findElementByLinkText("Multi-PopUp Test #2").click();
		
		String winhandle  = driver.getWindowHandle();
		System.out.println(winhandle);
		
		Set<String> winhandles  =driver.getWindowHandles();
		System.out.println(winhandles);
		winhandles.remove(winhandle);

		for (String eachwin : winhandles) {
			
			
			driver.switchTo().window(eachwin);   
			
			
			System.out.println(eachwin);
			driver.close();
			Thread.sleep(3000);
		
	}
	}

	
}
