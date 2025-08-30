package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumBaseStepDefinition extends BaseStepDefinition
{
	
	@Given("User is on SeleniumBase portal")
	public void user_is_on_selenium_base_portal() {
	    driver.get("https://seleniumbase.io/demo_page");
	}
	@When("User slides the slider")
	public void user_slides_the_slider() throws InterruptedException {
	   WebElement slider=driver.findElement(By.cssSelector("input#mySlider"));
	   actions.dragAndDropBy(slider, 50, 50).perform();;
	   Thread.sleep(3000);
	}
	@Then("it is moved")
	public void it_is_moved() {
		String expectedProgressText=driver.findElement(By.cssSelector("#progressLabel")).getText();
		Assert.assertEquals(expectedProgressText, "Progress Bar: (80%)");
	    System.out.println(expectedProgressText);
	}



}
