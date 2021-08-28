package hook;

import java.util.concurrent.TimeUnit;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import stepDefinition.BaseStepDefinition;

//public class Hook extends BaseStepDefinition {
public class Hook {
	
	
	@Before(order = 0)
    public void launchBrowser(){
		
		BaseStepDefinition.LaunchBrowser();
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		   wait=new WebDriverWait(driver,10);
		   js=(JavascriptExecutor)driver;*/

		   System.out.println("Browser launched");
    } 
 
 @After(order = 0)
    public void tearDown(){
	 
	 BaseStepDefinition.CloseBrowser();
       
    } 

}
