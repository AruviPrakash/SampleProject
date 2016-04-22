package opentapshw;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class EditLead extends OpenTapsWrapper {
	
  @Test(groups="sanity",dependsOnGroups="smoke")//(dependsOnMethods="week5opentapstestng.creatinglead")
  public void editleads() {
	  System.out.println("perform editlead");
  }
  @AfterMethod(groups="sanity",dependsOnGroups="smoke")
  public void afterMethod() {
	  System.out.println("verified editlead");
  }

}
