package week5opentapstestng;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class EditContact extends OpenTapsWrapper{
	
  @Test(groups="sanity",dependsOnGroups="smoke")
  public void editcontact() {
	  System.out.println("edit contact");
  }
  @AfterMethod(groups="sanity",dependsOnGroups="smoke")
  public void afterMethod() {
	  System.out.println("edit contact deleted");
  }

}
