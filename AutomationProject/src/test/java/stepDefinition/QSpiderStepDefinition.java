package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QSpiderStepDefinition extends BaseStepDefinition
{
	@Given("QSpider portal is open")
	public void q_spider_portal_is_open() 
	{
	    driver.get("https://demoapps.qspiders.com/");
	}
	@When("user navigates to modal")
	public void user_navigates_to_modal()
	{
	    driver.findElement(By.xpath("(//div[text()='Explore more'])[1]")).click();
	    driver.findElement(By.xpath("//section[text()='Popups']/..")).click();
	    driver.findElement(By.xpath("//a[@href='/ui/modal']")).click();
	    
	}
	@When("user clicks on open modal button")
	public void user_clicks_on_open_modal_button() 
	{
		driver.findElement(By.xpath("//button[text()='Open Modal']")).click();
	    
	}
	@Then("modal pop up is displayed")
	public void modal_pop_up_is_displayed() throws InterruptedException 
	{
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]//p")).getText(), "This is a custom Modal");
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("button#closeModal")).click();
	    Thread.sleep(1000);
	}




}
