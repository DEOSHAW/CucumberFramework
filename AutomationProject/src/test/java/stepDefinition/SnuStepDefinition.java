package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SnuStepDefinition extends BaseStepDefinition
{
	@Given("SNU portal is open")
	public void snu_portal_is_open() 
	{
	   driver.get("https://www.snuniv.ac.in/");
	}
	@When("user clicks on about link")
	public void user_clicks_on_about_link() 
	{
	    WebElement aboutSnuMenuLink=driver.findElement(By.xpath("//a[text()='ABOUT SNU']"));
	    WebElement aboutSnuLink=driver.findElement(By.xpath("//a[text()='About The Sister Nivedita University']"));
	    actions.moveToElement(aboutSnuMenuLink).pause(Duration.ofSeconds(1)).click(aboutSnuLink).perform();
	}
	@Then("user is naviagted to about page on SNU portal")
	public void user_is_naviagted_to_about_page_on_snu_portal()
    {
		WebElement aboutPageHeader=driver.findElement(By.cssSelector("h2.text-uppercase.mt-0.line-bottom "));
		Assert.assertEquals(aboutPageHeader.getText(), "About The Sister Nivedita University".toUpperCase());
	}
}
