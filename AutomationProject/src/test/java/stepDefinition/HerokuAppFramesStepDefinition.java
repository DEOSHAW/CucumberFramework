package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HerokuAppFramesStepDefinition extends BaseStepDefinition
{
	@Given("User is on Heroku Frames Portal")
	public void user_is_on_heroku_frames_portal()
	{
	    driver.get("https://testpages.herokuapp.com/pages/embedded-pages/frames/?utm_source=chatgpt.com");
	}
	@When("User switches to middle frame")
	public void user_switches_to_middle_frame() 
	{
	   driver.switchTo().frame(2);
	}
	@Then("the mid section is highlighted")
	public void the_mid_section_is_highlighted() throws InterruptedException
	{
		WebElement midSectionFirstElement=driver.findElement(By.xpath("//li[contains(@id,'middle')]"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", midSectionFirstElement);
		Thread.sleep(3000);
	}

}
