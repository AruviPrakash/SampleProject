package opentapshw;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class CreateContact extends OpenTapsWrapper {
	
  @Test(groups="smoke")
  public void createcontact() {
	  System.out.println("contact created" );
  }
  @AfterMethod(groups="smoke")
  public void afterMethod() {
	  System.out.println("contact verified");
  }

}
