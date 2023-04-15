package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IntelliasStepDefinition extends BaseStepDefinition {
	
	
	@Given("^Intellias portal is launched$")
	public void intellias_portal_is_launched() throws Exception
	{
		
		driver.get("https://intellias.com/");
		
		
	   
	}

	@When("^User navigates to about Section$")
	public void user_navigates_to_about_Section() throws Exception {
	   WebElement discoverIntellias=driver.findElement(By.xpath("//a[@title='Discover Intellias']"));
	   WebElement whoWeAreLink=driver.findElement(By.xpath("//a[string()='Who We Are']"));
	   
	   actions.moveToElement(discoverIntellias).click(whoWeAreLink).perform();
	   
	}

	@Then("^information about Intellias is displayed$")
	public void information_about_Intellias_is_displayed() throws Exception {
	 
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Intellias is a global technology partner')]")).getText());
		
	}


}
