//HW4  click on draggable and print the content of the element inside draggable and then click on droppable

package Week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryUi {

	public static void main(String[] args) throws InterruptedException {
	
System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
		ChromeDriver driver =new ChromeDriver();
		
		//Opens Webpage
		driver.get("http://jqueryui.com/");
		
		Thread.sleep(5000);
		
		//Clickthe link DRaggable
		driver.findElementByLinkText("Draggable").click();
		
		Thread.sleep(3000);
		
		//TO find number of frames
		List <WebElement> obj = driver.findElementsByTagName("iframe");
		
		System.out.println("THe number of frames : "  +obj.size());
		
		//TOswitch to child frame
		driver.switchTo().frame(driver.findElementByTagName("iframe"));
		
		System.out.println("THe text inside the frame is : " +driver.findElementById("draggable").getText());
			
		driver.close();
	
	}

}
