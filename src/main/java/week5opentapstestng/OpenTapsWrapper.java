package week5opentapstestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class OpenTapsWrapper {
  
  @BeforeMethod(groups={"smoke","sanity"})
  public void beforeMethod() {
	  System.out.println("login");
	  System.out.println("click crm");
	  System.out.println("click lead");
  }
@Parameters("browser")
  @BeforeClass(groups={"smoke","sanity"})
  public void beforeClass(String browser) {
	  System.out.println("lanch browers"+browser);
  }

  @AfterClass(groups={"smoke","sanity"})
  public void afterClass() {
	  System.out.println("close brower");
  }

}
