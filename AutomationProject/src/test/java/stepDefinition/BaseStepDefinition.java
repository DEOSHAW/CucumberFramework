package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseStepDefinition {
	protected static WebDriver driver=null;
	protected static WebDriverWait wait=null;
	protected static JavascriptExecutor js=null;
	
	
	public static void LaunchBrowser()
	{
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		   wait=new WebDriverWait(driver,10);
		   js=(JavascriptExecutor)driver;
		
	}
	
	

}
