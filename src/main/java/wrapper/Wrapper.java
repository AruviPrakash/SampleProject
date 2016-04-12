package wrapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class Wrapper extends ExcelWrapper{
	
	RemoteWebDriver driver;
	
	public String Parentwinhandle;
	//TO Launch Webpage
	public void LaunchApp(String  browser ,String  url)
	{
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				driver =new FirefoxDriver();		}
			else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver" ,"./driver/chromedriver.exe");
				driver = new ChromeDriver();		}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
			
			//To get parent window handle
			
			Parentwinhandle  = driver.getWindowHandle();
			System.out.println("THe parent window handle" +Parentwinhandle);
			
			} 
		catch (WebDriverException e) {
			System.out.println("Browser Not launched");
			}
	}
	
	//To enter text value
	public void EntertextValue(String typename,String Element,  String value)
	{
		try {
			if(typename.equals("id"))       {
			driver.findElement(By.id(Element)).clear();
			driver.findElement(By.id(Element)).sendKeys(value,Keys.TAB);}
		else if(typename.equals("name"))	{	
			driver.findElement(By.name(Element)).clear();
			driver.findElement(By.name(Element)).sendKeys(value);}
		else if(typename.equals("className"))	{	
			driver.findElement(By.className(Element)).clear();
			driver.findElement(By.className(Element)).sendKeys(value);}
		else if(typename.equals("xpath"))	{	
			driver.findElement(By.xpath(Element)).clear();
			driver.findElement(By.xpath(Element)).sendKeys(value);}
		else if(typename.equals("cssSelector"))	{	
			driver.findElement(By.cssSelector(Element)).clear();
			driver.findElement(By.cssSelector(Element)).sendKeys(value);}
		}
		catch (NoSuchElementException e) {
			System.out.println("Element was not found on page");}
	}
		
	//TO Click
	public void Click(String typename,String Element)
	{
		try {
			if(typename.equals("id"))       {
				driver.findElement(By.id(Element)).click();}
			else if(typename.equals("name"))	{	
				driver.findElement(By.name(Element)).click();}
			else if(typename.equals("className"))	{	
				driver.findElement(By.className(Element)).click();}
			else if (typename.equals("xpath"))	{	
				driver.findElement(By.xpath(Element)).click();}
			else if (typename.equals("cssSelector"))	{	
				driver.findElement(By.cssSelector(Element)).click();}
			else if (typename.equals("linkText"))	{	
				driver.findElement(By.linkText(Element)).click();}
		} 
		catch (NoSuchElementException e) {
			System.out.println("Element was not found on page");}
	}
	 
	//TO verify the webpage title
	public void VerifyTitle(String expectedtitle)
	{
		try {
			String actualtitle = driver.getTitle();
			if (expectedtitle.equals(actualtitle)) {
			System.out.println("Title verified: actual matches the expected");
			System.out.println("The actual title is" + actualtitle);
			System.out.println("The expected title is "+ expectedtitle );}
			else {
			System.out.print("Title verified: actual does not match the expected");
			System.out.println("The actual title is" + actualtitle);
			System.out.println("The expected title is "+ expectedtitle );}
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found on page");}
	}
	
	//To Verify text
	public void VerifyTxt(String expectedtext,String Element)
	{
		try {
			String actualtext = driver.findElement(By.id(Element)).getText();
			if (expectedtext.equals(actualtext)) {
			System.out.println("Text verified: actual matches the expected");
			System.out.println("The actual text is" + actualtext);
			System.out.println("The expected text is"+ expectedtext );}
			else {
			System.out.print("text verified: actual does not match the expected");
			System.out.println("The actual text is" + actualtext);
			System.out.println("The expected text is"+ expectedtext );}
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found on page");}
	}
	
	//To Verify Url
	public void VerifyUrl(String expectedurl)
	{
		try {
			String actualurl = driver.getCurrentUrl();
			if (expectedurl.equals(actualurl)) {
				System.out.println("Text verified: actual matches the expected");
				System.out.println("The actual url is" + actualurl);
				System.out.println("The expected url is"+ expectedurl );}
			else {
				System.out.println("Text verified: actual does not match the expected");
				System.out.println("The actual url is" + actualurl);
				System.out.println("The expected url is"+ expectedurl );}
		} catch (Exception e) {
			System.out.println("URL did not match");
		}
	}
	
	
	//Alert (Accept and DIsmiss)
	public boolean Alerts(String actiononalert)
	{
		try 
		    { 
		        Alert myalert = driver.switchTo().alert(); 
		        if (actiononalert.equals("accept") )
		        {
		        	myalert.accept();
		        }
		        else if (actiononalert.equals("dismiss") )
		        {
		        	myalert.dismiss();
		        }
		        	
		        return true; 
		    }   
		    catch (NoAlertPresentException Ex) 
		    { 
		        return false; 
		    }
		 
	}
		
	
	//To select a value from dropdown
	public void selectValueByIndex(int Index,String typename,String Element){
		
		try {
			if(typename.equals("id"))       {
				WebElement ele= driver.findElement(By.id(Element));
				Select obj = new Select(ele);
				obj.selectByIndex(Index);}
			else if(typename.equals("name"))	{	
				WebElement ele= driver.findElement(By.name(Element));
				Select obj = new Select(ele);
				obj.selectByIndex(Index);}
			else if(typename.equals("className"))	{	
				WebElement ele= driver.findElement(By.className(Element));
				Select obj = new Select(ele);
				obj.selectByIndex(Index);}
			else if (typename.equals("xpath"))	{	
				WebElement ele= driver.findElement(By.xpath(Element));
				Select obj = new Select(ele);
				obj.selectByIndex(Index);}
			else if (typename.equals("cssSelector"))	{	
				WebElement ele= driver.findElement(By.cssSelector(Element));
				Select obj = new Select(ele);
				obj.selectByIndex(Index);}
			else if (typename.equals("linkText"))	{	
				WebElement ele= driver.findElement(By.linkText(Element));
				Select obj = new Select(ele);
				obj.selectByIndex(Index);}
		} 
		catch (NoSuchElementException e) {
			System.out.println("Element was not found on page");
		}
	}
	
	//To switch to primary window
	public void switchToPrimaryWindow()
	{
		try {
			driver.switchTo().window(Parentwinhandle);
			System.out.println("Switch to Parent window");
			System.out.println(Parentwinhandle);
		} catch (NoSuchWindowException e) {
			System.out.println("Error in switching to parent  window");;
		}
	}
	
	//To switch to the last window
	public void switchToLastWindow()
	{	
					
		Set<String> winhandles  =driver.getWindowHandles();
		//System.out.println(winhandles);
		//winhandles.remove(winhandle);

		System.out.println("List of windows");
		for (String eachwin : winhandles) {
			driver.switchTo().window(eachwin); 
			System.out.println(eachwin);
			}
		System.out.println("Switch to the last window");
		System.out.println(driver.getWindowHandle());
	}	

	//To switch to frame by using tagname
	public void switchToFrameByElement(String frameElement)
	{
		
		try {
			
			WebElement frame = driver.findElement(By.tagName(frameElement));
			driver.switchTo().frame(frame);
			}
		 catch (NoSuchFrameException e) {
			System.out.println("Frame not found");
		}
	}
	
	//To switch to frame with index zero 
	public void switchToFirstFrame()
	{
		try {
			driver.switchTo().frame(0);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame not found");
		}
		
	}
}

