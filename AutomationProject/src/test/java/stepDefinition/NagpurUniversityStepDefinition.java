package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NagpurUniversityStepDefinition extends BaseStepDefinition
{
	@Given("Nagpur University portal is open")
	public void nagpur_university_portal_is_open() 
	{
	   driver.get("https://nagpuruniversity.ac.in/");
	}
	@When("User clicks on About link on Nagpur University portal")
	public void user_clicks_on_about_link_on_nagpur_university_portal() 
	{
	    WebElement aboutUsLink=driver.findElement(By.xpath("(//a[contains(text(),'About Us')])[1]"));
	    WebElement aboutUniversityLink=driver.findElement(By.xpath("(//a[contains(text(),'About University')])[1]"));
	    actions.moveToElement(aboutUsLink).pause(Duration.ofSeconds(1)).click(aboutUniversityLink).perform();
	}
	@Then("User is navigated to the About University page on Nagpur University portal")
	public void user_is_navigated_to_the_about_university_page_on_nagpur_university_portal()
	{
	    Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "About University","User is not About University page");
	}
}
