package opentapsweek5;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class DeleteLead1 extends OpentapsWrapper {
  @Test ( dependsOnMethods = "CreateLead" )
  public void DeleteLead() {
	  System.out.println("DeleteLead");
  }
  @AfterMethod
  public void VerifyDeletedLead() {
	  System.out.println("Verify Deleted Lead");
  }

}
