package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IBSFStepDefinition extends BaseStepDefinition
{
	
	@Given("User is on IBSF portal")
	public void user_is_on_ibsf_portal() {
	    driver.get("https://www.ibsf.org/en/");
	}
	@When("user scrolls down to bottom on IBSF portal")
	public void user_scrolls_down_to_bottom_on_ibsf_portal() 
	{
	    WebElement socialMediaElement=driver.findElement(By.xpath("//h4[string()='Social Media']"));
	    js.executeScript("arguments[0].scrollIntoView();", socialMediaElement);
	}
	@Then("below social media is highlighted")
	public void below_social_media_is_highlighted(io.cucumber.datatable.DataTable dataTable) throws InterruptedException 
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		String socialMediaText=dataList.get(1).get(0);
		WebElement socialMediaHandle=driver.findElement(By.xpath("//a[@title='"+socialMediaText+"']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", socialMediaHandle);
		Thread.sleep(3000);
	    
	}

}
