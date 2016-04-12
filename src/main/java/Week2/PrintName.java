package Week2;
//HW3
	//Program to find the number of links that  has"aruvi" ineither case in 
	//oglesearch results when you search byaruvi
	// the length of the link is more than 20 characters and the position of x is greater than 100.
	

	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class PrintName {

			public static void main(String[] args) throws InterruptedException {
			
			//CHromedriver
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			
			//OpensGoogle
			driver.get("https://www.google.co.in");
			
			//driver.manage().window().maximize();
			
			//TO enter"Aruvi"in searchfield
			driver.findElementById("lst-ib").sendKeys("Aruvi");
					
			// To Click search
			driver.findElementByXPath("//*[@id=\"sblsbb\"]/button/span").click();
			
			Thread.sleep(3000);
			
			//To get the list of links displayed with tag name
			List<WebElement> name = driver.findElementsByTagName("a");
			
			System.out.println("THe links are");
			
			int x=0;
			
			for (WebElement myname : name) {
				
				if((myname.getText().contains("aruvi")) || (myname.getText().contains("Aruvi")))
				{
				
					
					int str ;
					str = myname.getText().length();
					
					//System.out.println(myname.getText());
					if ((str >20) && (myname.getLocation().getX()>100)){
					
						System.out.println(myname.getText());
						x=x+1;		
				}
						
			}
			
			
		}
			System.out.println("The numberof links are " +x);
			driver.close();
			
		}
			
			
	}



