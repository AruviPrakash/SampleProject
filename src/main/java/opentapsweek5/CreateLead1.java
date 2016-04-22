package opentapsweek5;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class CreateLead1 extends OpentapsWrapper{
  @Test(invocationCount=2 ,threadPoolSize = 2)
  public void CreateLead() {
	  System.out.println("CreateLead");
  }
  @AfterMethod
  public void VerifyCreatedLead() {
	  System.out.println("Verify Created Lead");
  }

}
