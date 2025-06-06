package stepDefinition;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;



public class BaseStepDefinition {
	protected static WebDriver driver=null;
	protected static WebDriverWait wait=null;
	protected static JavascriptExecutor js=null;
	protected static Actions actions=null;
	
	
	public static void LaunchBrowser()
	{
		   //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
	      options.addArguments("--remote-allow-origins=*");
	      options.addArguments("--no-sandbox");
	      options.addArguments("--disable-dev-shm-usage");
	      options.addArguments("log-level=2");
	      //options.addArguments("--headless");
		   driver=new ChromeDriver(options);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		   js=(JavascriptExecutor)driver;
		   actions=new Actions(driver);
		 
		
	}


	public static void CloseBrowser(Scenario scenario) {
		
		    if(scenario.isFailed())
		    {
		    	TakesScreenshot ts=(TakesScreenshot)driver;
		    	File src=ts.getScreenshotAs(OutputType.FILE);
		    	File dest=new File(System.getProperty("user.dir")+File.separator+"resources"+File.separator+scenario.getName().replaceAll("\\s","_")+".png");
		    	try
		    	{
		    		if(dest.exists())
		    		{
		    			dest.delete();
		    		}
		    	FileHandler.copy(src, dest);
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	
		    }
		    driver.quit();
	        System.out.println("Browser closed");
		
	}
	
	

}
