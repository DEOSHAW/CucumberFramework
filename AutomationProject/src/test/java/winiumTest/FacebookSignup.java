package winiumTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FacebookSignup {
	
	public static void main(String args[]) throws InterruptedException, Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Actions builder=new Actions(driver);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement day=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Day']")));
		Select Day=new Select(day);
		WebElement month=driver.findElement(By.xpath("//*[@title='Month']"));
		Select Month=new Select(month);
		WebElement year=driver.findElement(By.xpath("//*[@title='Year']"));
		Select Year=new Select(year);
		Action MouseHover=builder.moveToElement(month).build();
		MouseHover.perform();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		Day.selectByIndex(3);
		Thread.sleep(2000);
		Month.selectByValue("9");
		Thread.sleep(2000);
		Year.selectByVisibleText("1991");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Sign Up"));
		Thread.sleep(5000);
		driver.close();
		
	}
}