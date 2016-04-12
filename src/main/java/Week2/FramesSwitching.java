//HW2Closeall the frames other than thecentre one.Some of the close button is inside a frame and some are not. So you should move inside a frame and check if there are any close button. If yes, click of all them

package Week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesSwitching {

	public static void main(String[] args) throws InterruptedException {

		//CHromedriver
				System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
				
				ChromeDriver driver =new ChromeDriver();
				
				//Opens Webpage
				driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
				Thread.sleep(5000);
				
				//tofind number of frames
				List<WebElement> frame = driver.findElementsByTagName("iframe");
			    System.out.println("Number of frames in a page :" + frame.size());

			    //TO switch to the frame
			    driver.switchTo().frame(driver.findElementByTagName("iframe"));
			   
			    //List<WebElement> closeme = driver.findElementsByName"Close Me");
			   // System.out.println("button"+closeme);
			  // for (WebElement eachclose : closeme) {
				   //eachclose.click();
				  

			//}
			  
			  //To closthe frames  
			  driver.findElementByXPath("/html/body/div[2]/p/button").click();
			  driver.findElementByXPath("/html/body/div[3]/p/button").click();
			  driver.switchTo().defaultContent();
			  driver.findElementByXPath("/html/body/div[1]/p[1]/button").click();
			  
			  driver.findElementByXPath("/html/body/div[2]/p/button").click();
			    driver.close();

			    
	}

}
