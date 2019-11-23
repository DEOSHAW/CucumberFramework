package winiumTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String FirstWindow=driver.getWindowHandle();
		System.out.println("First Window Handle is"+FirstWindow);
		System.out.println("First Window Title is"+driver.getTitle());
		WebElement NewBrowserLink=driver.findElement(By.xpath("//*[text()='New Browser Window']"));
		NewBrowserLink.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Set<String> WindowHandleList=driver.getWindowHandles();
		System.out.println("Size is"+WindowHandleList.size());
		for(String Handles:WindowHandleList)
			System.out.println("Handles are:"+Handles);
		WindowHandleList.remove(FirstWindow);
		Iterator<String> HandlesLeft=WindowHandleList.iterator();
		while(HandlesLeft.hasNext())
		{
			String CurrentWindow=HandlesLeft.next();
			System.out.println("Remaining window Handle is"+CurrentWindow);
			driver.switchTo().window(CurrentWindow);
			System.out.println("Current Window Title is"+driver.getTitle());
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			
			
		}
		//for(String HandlesRemaining:WindowHandleList)
			//driver.switchTo().window(HandlesRemaining);
		//System.out.println("Current Window Title is"+driver.getTitle());
		//driver.manage().window().maximize();
		//Thread.sleep(5000);
			
		
		driver.quit();
		
		}

}
