package opentapshw;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class DeleteContact extends OpenTapsWrapper{
	
  @Test(groups="sanity" ,dependsOnGroups="smoke")
  public void deletecontact() {
	  System.out.println("contact deleted");
  }
  @AfterMethod(groups="sanity",dependsOnGroups="smoke")
  public void afterMethod() {
	  System.out.println("delete contact deleted");
  }

}
