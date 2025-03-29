package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumBaseIoStepDefinition extends BaseStepDefinition
{
	
	@Given("User is on SeleniumBaseIO portal is open")
	public void user_is_on_selenium_base_io_portal_is_open() 
	{
	    driver.get("https://seleniumbase.io/demo_page/");
	}
	@When("User navigates to iframe text")
	public void user_navigates_to_iframe_text() 
	{
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()='Image in iFrame:']")));
	}
	@Then("iframe text is highlighted")
	public void iframe_text_is_highlighted() throws InterruptedException 
	{
		driver.switchTo().frame("frameName2");
		WebElement iframeText=driver.findElement(By.tagName("h4"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", iframeText);
		Thread.sleep(300);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("myFrame3");
		driver.findElement(By.id("checkBox6")).click();
		Thread.sleep(1000);
		
	    
	}

}
