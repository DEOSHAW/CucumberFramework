package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IIAEStepDefinition extends BaseStepDefinition
{
	@Given("User is on IIAE portal")
	public void user_is_on_iiae_portal() {
	    driver.get("https://iiaepune.org/");
	    WebElement closeButton=driver.findElement(By.cssSelector("button.close"));
	    if(closeButton.isDisplayed())
	    {
	    	closeButton.click();
	    }
	}
	@When("User clicks on about link on IIAE portal")
	public void user_clicks_on_about_link_on_iiae_portal() 
	{
	    WebElement aboutUsMenuLink=driver.findElement(By.xpath("(//a[@href='About-Us'])[1]"));
	    WebElement aboutCollegeLink=driver.findElement(By.xpath("(//a[text()='Indira IAE College '])[1]"));
	    actions.moveToElement(aboutUsMenuLink).click(aboutCollegeLink).perform();
	}
	@Then("User is navigated to about page on IIAE portal")
	public void user_is_navigated_to_about_page_on_iiae_portal() {
	    Assert.assertEquals(driver.getCurrentUrl(), "https://iiaepune.org/About-Us");
	}

}
