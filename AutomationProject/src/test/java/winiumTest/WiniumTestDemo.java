package winiumTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;

import java.net.URL;

public class WiniumTestDemo {
	WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
    @Test
    public void SeleniumTest() throws Exception
    {  
    	driver.navigate().to("https://www.gmail.com");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='email']")));
    	driver.findElement(By.xpath("//*[@type='email']")).sendKeys("deoshaw3@gmail.com");
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//*[text()='Next']")).click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	System.out.println(driver.findElement(By.xpath("//*[text()='Welcome']")).getText());
    	if(driver.findElement(By.xpath("//*[text()='Welcome']")).getText().contains("Welcome"))
    	{
    	driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Dd03091991");
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//*[text()='Next']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
    	driver.findElement(By.xpath("//*[text()='Compose']")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	
    	}
    	
    	
    	
        
     }
    @AfterTest
    public void CloseBrowser()
    {
    	//driver.close();
    }

}
