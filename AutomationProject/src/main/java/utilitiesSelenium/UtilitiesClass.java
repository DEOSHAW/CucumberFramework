package utilitiesSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilitiesClass {
	
	public static WebDriver LaunchBrowser(WebDriver driver,String site)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.get(site);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		   return driver;
	}

}
