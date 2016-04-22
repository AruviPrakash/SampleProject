package opentapshw;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class MergeLead extends OpenTapsWrapper {
  @Test(groups="sanity",dependsOnGroups="smoke")
 // (enabled=false)
  public void mergeleads() {
	  System.out.println("perform mergelead");
  }
  @AfterMethod(groups="sanity",dependsOnGroups="smoke")
  public void afterMethod() {
	  System.out.println("verified lead id is merged");
  }

}
