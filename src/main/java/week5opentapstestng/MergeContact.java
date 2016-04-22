package week5opentapstestng;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class MergeContact extends OpenTapsWrapper {
	
  @Test(groups="sanity",dependsOnGroups="smoke")
  public void mergecontact() {
	  System.out.println("mergecontact");
  }
  @AfterMethod(groups="sanity",dependsOnGroups="smoke")
  public void afterMethod() {
	  System.out.println("merge contact deleted");
  }

}
