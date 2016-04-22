package opentapshw;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class DeleteLead extends OpenTapsWrapper {
	
  @Test(groups="sanity",dependsOnGroups="smoke")//(dependsOnMethods="CreateLead",timeOut=10000)
  public void deletelead() {
	  System.out.println("perform delete lead");
  }
  @AfterMethod(groups="sanity",dependsOnGroups="smoke")
  public void afterMethod() {
	  System.out.println("verified leadid deleted");
  }

}
