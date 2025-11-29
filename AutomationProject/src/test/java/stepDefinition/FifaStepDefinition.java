package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FifaStepDefinition extends BaseStepDefinition
{
	
	@Given("Fifa portal is open")
	public void fifa_portal_is_open() {
	    driver.get("https://www.fifa.com/en");
	}
	@Then("page title is displayed")
	public void page_title_is_displayed() {
		driver.findElement(By.cssSelector("button#onetrust-reject-all-handler")).click();
		driver.findElement(By.cssSelector("div.pop-up_closeIcon__etsqq")).click();
	    Assert.assertEquals(driver.getTitle(), "FIFA | The Home of Football");
	}


}
