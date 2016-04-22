package opentapsweek5;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class EditLead1 extends OpentapsWrapper {
  @Test (dependsOnMethods = "CreateLead")
  public void EditLead() {
	  System.out.println("EditLead");
  }
  @AfterMethod
  public void VerifyEditLead() {
	  System.out.println("Verify Edit Lead");
  }

}
