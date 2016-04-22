package opentapsweek5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class OpentapsWrapper {
/*  @Test
  public void f() {
  }*/
	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Login + Click CRM + Click Lead tab");
  }

  @BeforeClass
  public void LaunchBrowser() {
	  System.out.println("Launch Browser");
  }

  @AfterClass (alwaysRun  = true)
  public void CloseBrowser() {
	  System.out.println("Close Browser");
  }

}
