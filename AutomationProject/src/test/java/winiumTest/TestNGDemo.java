package winiumTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@Parameters({ "val1","val2" })
	@Test
	   public void prameterTestOne(int val1,int val2) {
	   System.out.println("Sum of the values is: " + (val1+val2));
	   Reporter.log("Logged",true);
	  
	}

}
