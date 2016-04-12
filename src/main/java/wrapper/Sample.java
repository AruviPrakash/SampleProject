package wrapper;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample extends Wrapper{

	@Test
	
	public void sampletest () throws InterruptedException
	{
		
		LaunchApp("chrome","http://layout.jquery-dev.com/demos/iframe_local.html" );

		//driver.findElementByLinkText("Multi-PopUp Test #2").click();
		//switchToLastWindow();
		//switchToPrimaryWindow();
		switchToFrameByElement("iframe");
		
	}
}
