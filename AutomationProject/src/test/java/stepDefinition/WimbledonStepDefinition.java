package stepDefinition;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WimbledonStepDefinition extends BaseStepDefinition
{
	
	@Given("^Wimbledon portal is open$")
	public void wimbledon_portal_is_open() throws Exception {
	   driver.get("https://www.wimbledon.com/");
	}

	@When("^User clicks on Entry list link$")
	public void user_clicks_on_Entry_list_link() throws Exception {
	WebElement entryListLink=driver.findElement(By.xpath("(//a[contains(@title,'link to /en_GB/atoz') and contains(text(),'Entry Lists')])[2]"));
	//wait.until(ExpectedConditions.visibilityOf(entryListLink));
	js.executeScript("arguments[0].click();", entryListLink);
	//js.executeScript("window.scrollBy(0,200)");
	driver.findElement(By.xpath("(//p[contains(text(),'Main Draw')])[1]")).click();
	js.executeScript("window.scrollBy(0,200)");
	driver.findElement(By.xpath("(//a[contains(text(),'Gentlemen')])[3]")).click();
	}

	@Then("^the entry list is displayed$")
	public void the_entry_list_is_displayed() throws Exception {
		
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String win:allWindows)
		{
			if(!win.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(win);
				break;
				
			}
		}
		Thread.sleep(2000);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+File.separator+"EntryList"+".png");
		FileHandler.copy(src, dest);
	
	}



}
