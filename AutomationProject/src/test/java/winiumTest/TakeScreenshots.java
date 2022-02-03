package winiumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshots {
	
	
	@Test
     void TakescreenshotHandle() throws IOException
	{
	
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.toolsqa.com/automation-practice-switch-windows/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	System.out.println(driver.getPageSource());
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	org.openqa.selenium.io.FileHandler.copy(file, new File(System.getProperty("user.dir")+File.separator+"toosqa.jpg"));
	//FileHandler.copyFile(file, new File("D:\\MP3 SONGS\\toosqa.jpg"));
	}
	

}
