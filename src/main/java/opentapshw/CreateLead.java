package opentapshw;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class CreateLead extends OpenTapsWrapper{
	
  @Test(dataProvider="mydata",groups="smoke")
  // (invocationCount=2,threadPoolSize=2)
  public void creatinglead(String Companyname) {
	  System.out.println("diplay lead id created");
	  System.out.println(Companyname);
	  System.out.println("mmmm" +Companyname);
  }
  @AfterMethod(groups="smoke")
  public void afterMethod() {
	  System.out.println("lead id verified");
	  
  }
/*@DataProvider(name="testdata")
public Object[][] gettestdata()
{
	Object[][] data=new Object[2][5];
	data[0][0]="username";
	data[1][0]="username";
	data[0][1]="password";
	data[1][1]="password";
	data[0][2]="company name1";
	data[1][2]="company name2";
	data[0][3]="firstname1";
	data[1][3]="firstname2";
	data[0][4]="lastname1";
	data[1][4]="lastname2";
	
	return data;
	
}*/
  
}
