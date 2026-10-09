package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AshokaUniversityStepDefinition extends BaseStepDefinition
{
	@Given("Ashoka University portal is open")
	public void ashoka_university_portal_is_open() 
	{
	   driver.get("https://www.ashoka.edu.in/"); 
	}
	@When("User clicks on study at ashoka button")
	public void user_clicks_on_study_at_ashoka_button() 
	{
		actions.click(driver.findElement(By.xpath("(//button[@class='owl-next'])[1]"))).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-controls='aw-study-drawer']"))).click();
	}
	@Then("Study at Ashoka modal is displayed")
	public void study_at_ashoka_modal_is_displayed() throws InterruptedException 
	{
	    WebElement modalTitle=driver.findElement(By.cssSelector("h2.aw-title"));
	    Assert.assertTrue(modalTitle.isDisplayed());
	    Assert.assertEquals(modalTitle.getText(), "Study at Ashoka");
	    Thread.sleep(3000);
	}

}
