package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HCLStepDefinition extends BaseStepDefinition {
	String bannerText;
	@Given("^HCL portal is launched$")
	public void hcl_portal_is_launched() throws Exception {
	    driver.get("https://www.hcltech.com/");
	}

	@When("^user Extracts the news$")
	public void user_Extracts_the_news() throws Exception {
	   WebElement bannerElement=driver.findElement(By.xpath("(//*[@class='home-banner-inner']/h2)[3]"));
	  bannerText= wait.until(ExpectedConditions.visibilityOf(bannerElement)).getText();
	}

	@Then("^the news is displayed$")
	public void the_news_is_displayed() throws Exception {
	    System.out.println(bannerText);
	}

}
