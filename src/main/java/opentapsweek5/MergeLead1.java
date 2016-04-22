package opentapsweek5;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class MergeLead1 extends OpentapsWrapper {
  @Test (enabled=  false)
  public void MergeLead() {
	  System.out.println("MergeLead");
  }
  @AfterMethod //(enabled=  false)
  public void VerifyMergedLead() {
	  System.out.println("Verify Merged Lead");
  }

}
