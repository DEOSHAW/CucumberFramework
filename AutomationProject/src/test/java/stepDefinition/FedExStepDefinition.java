package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FedExStepDefinition extends BaseStepDefinition
{

	@Given("FedEx portal is open")
	public void fed_ex_portal_is_open() {
	    driver.get("https://www.fedex.com/en-in/home.html");
	}
	@When("User is on Homepage")
	public void user_is_on_homepage() {
	    Assert.assertEquals(driver.getCurrentUrl(),"https://www.fedex.com/en-in/home.html");
	}
	@Then("major functions are highlighted")
	public void major_functions_are_highlighted() throws InterruptedException {
	   List<WebElement> allFunctions= driver.findElements(By.xpath("//li[contains(@id,'cube')]"));
	   Iterator<WebElement> itr=allFunctions.iterator();
	   while(itr.hasNext())
	   {
		   
		   js.executeScript("arguments[0].setAttribute('style', 'border:2px solid green; background:Red')", itr.next());
		   Thread.sleep(800);
			
	   }
	   
	}
}
