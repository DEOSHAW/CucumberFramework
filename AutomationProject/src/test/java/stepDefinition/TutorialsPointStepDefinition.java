package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TutorialsPointStepDefinition extends BaseStepDefinition
{
	@When("Tutorials point slider site is open")
	public void tutorials_point_slider_site_is_open()
	{
	    driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");
	}
	@When("user selects {string}")
	public void user_selects(String value)
	{
		WebElement slider=driver.findElement(By.xpath("//input[@id='ageInputId']"));
		for(int i=0;i<79;i++)
		{
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
		actions.dragAndDropBy(slider, 50, 0);
	    
	}
	@Then("the value is selected")
	public void the_value_is_selected() throws InterruptedException
	{		
	    Assert.assertEquals(driver.findElement(By.cssSelector("#ageOutputId")).getText(), "80");
	    Thread.sleep(3000);
	}




}
