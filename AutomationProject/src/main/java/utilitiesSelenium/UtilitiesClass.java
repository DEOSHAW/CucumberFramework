package utilitiesSelenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilitiesClass {
	
	public static void LaunchBrowser(String site,WebDriver driver)
	{
		  driver.get(site);
	}

}
