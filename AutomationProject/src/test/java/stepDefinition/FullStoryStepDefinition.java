package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FullStoryStepDefinition extends BaseStepDefinition
{
	
	@Given("FullStory portal is open")
	public void full_story_portal_is_open()
	{
	    driver.get("https://www.fullstory.com/");
	}
	@When("User navigates to platform section")
	public void user_navigates_to_platform_section()
	{
		actions.moveToElement(driver.findElement(By.xpath("(//a[text()='Product'])[1]"))).perform();
	   
	}
	@Then("platform of FullStory get listed")
	public void platform_of_full_story_get_listed() throws InterruptedException 
	{
		List<WebElement> platformList=driver.findElements(By.xpath("//div[text()='Platform Overview']/../following-sibling::div//a"));
		Iterator<WebElement> itr=platformList.iterator();
		StringBuffer stb=new StringBuffer();
		while(itr.hasNext())
		{
			stb.append(itr.next().getText());
			stb.append("\n");
			
		}
		js.executeScript("alert(arguments[0])", stb.toString());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
	}


}
