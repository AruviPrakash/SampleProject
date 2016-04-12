//HW ! 1. Find the number of frames within the application (only in chrome):
//Tip: The application has nested frames of only one level. Hence you need to go within each frame and check if that frame has any child frame or not? And then you need to come out and go to next frame.


package Week2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LayoutFrames {

	public static void main(String[] args) throws InterruptedException {
		
		//CHromedriver
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
		ChromeDriver driver =new ChromeDriver();
		
		//Opens Webpage
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");
		Thread.sleep(5000);
		
		List<WebElement> frame = driver.findElementsByTagName("iframe");
		
		int i = frame.size();
		int j = 0;
	    System.out.println("Number of frames in a page :" + i);
	    
	    int subFrameIndex =0;
	    for(WebElement newframe : frame){
	      
	      //Returns the  value of src attribute
	        System.out.println("Frame name :" + newframe.getAttribute("src"));
	        
	        //Switch to subframe
	        driver.switchTo().frame(subFrameIndex);
		    List<WebElement> frame1 = driver.findElementsByTagName("iframe");
		    
		     j = frame1.size();
		    System.out.println("Number of subframes  :" + j);
		    
		    driver.switchTo().defaultContent();
		    
		    subFrameIndex++;
		    
		    driver.close();
	    }
	    
	    
	   //ystem.out.println("Frames"  +driver.findElements(By.xpath("//iframe")).size());
	    
	    
	   
	    
	}

}
