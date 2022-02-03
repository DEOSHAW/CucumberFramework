package stepDefinition;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseStepDefinition {
	protected static WebDriver driver=null;
	protected static WebDriverWait wait=null;
	protected static JavascriptExecutor js=null;
	protected static Actions actions=null;
	
	
	public static void LaunchBrowser()
	{
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		   js=(JavascriptExecutor)driver;
		   actions=new Actions(driver);
		 
		
	}


	public static void CloseBrowser() {
		    driver.quit();
	        System.out.println("Browser closed");
		
	}
	
	

}
