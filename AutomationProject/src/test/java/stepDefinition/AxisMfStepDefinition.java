package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AxisMfStepDefinition extends BaseStepDefinition
{
	static String parentWindow;
	@Given("User is on Axis mutual fund portal")
	public void user_is_on_axis_mutual_fund_portal() 
	{
	    driver.get("https://www.axismf.com/");
	    driver.findElement(By.cssSelector("div#nvpush_cross")).click();
	}
	@When("User clicks on KYC corner link")
	public void user_clicks_on_kyc_corner_link() 
	{
		WebElement kycLink=driver.findElement(By.xpath("//ion-label[text()='KYC Corner']"));
		js.executeScript("arguments[0].click();", kycLink);
	}
	@When("User clicks on Check KYC status")
	public void user_clicks_on_check_kyc_status() throws InterruptedException
	{
		parentWindow=driver.getWindowHandle();
		WebElement kycImage=driver.findElement(By.xpath("(//ion-img[@alt='kyc status'])[1]")).getShadowRoot().findElement(By.cssSelector("img"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", kycImage);
		Thread.sleep(2000);
		kycImage.click();
	}
	@Then("User is redirected to KYC site")
	public void user_is_redirected_to_kyc_site()
	{
	    Set<String> allWindows=driver.getWindowHandles();
	    Iterator<String> itr=allWindows.iterator();
	    while(itr.hasNext())
	    {
	    	String currentWindow=itr.next();
	    	if(!currentWindow.equalsIgnoreCase(parentWindow))
	    	{
	    		driver.switchTo().window(currentWindow);
	    		break;
	    	}
	    }
	    Assert.assertEquals(driver.getTitle(), "Know Your Status");
	}

}
