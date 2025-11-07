package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBankStepDefinition extends BaseStepDefinition
{
	@Given("ParaBank portal is open")
	public void para_bank_portal_is_open() {
	    driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	@When("User clicks on readmore link")
	public void user_clicks_on_readmore_link() {
	    driver.findElement(By.xpath("(//a[text()='Read More'])[2]")).click();
	}
	@Then("News section is displayed")
	public void news_section_is_displayed() {
	    String title=driver.findElement(By.cssSelector("h1.title")).getText();
	    Assert.assertEquals(title, "ParaBank News");
	}

}
