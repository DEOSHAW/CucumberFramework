package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JioPaymentsBankStepDefinition extends BaseStepDefinition
{
	@Given("Jio Payments Bank portal is open")
	public void jio_payments_bank_portal_is_open() 
	{
	    driver.get("https://www.jiopayments.bank.in/");
	}
	@When("User navigates to about us page")
	public void user_navigates_to_about_us_page() 
	{
	    WebElement ourCompanyMenu=driver.findElement(By.xpath("//div[text()='Our company']"));
	    actions.moveToElement(ourCompanyMenu).perform();
	    driver.findElement(By.xpath("//div[text()='About us']")).click();
	    
	}
	@Then("the motto is highlighted")
	public void the_motto_is_highlighted() throws InterruptedException 
	{
	    WebElement mottoElement=driver.findElement(By.xpath("//strong[contains(text(),'Join us in shaping the future')]"));
	    js.executeScript("arguments[0].scrollIntoView();", mottoElement);
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", mottoElement);
	    Thread.sleep(1000);
	}

}
