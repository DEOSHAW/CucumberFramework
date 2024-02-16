package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SamsungStepDefinition extends BaseStepDefinition
{
	@Given("Samsung portal is launched")
	public void samsung_portal_is_launched() 
	{
	   driver.get("https://www.samsung.com/in/");
	}
	@When("User Clicks on Search button")
	public void user_clicks_on_search_button() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//button[@an-la='search'])[2]")));
	    
	}
	@When("User Searches for {string} on Samsung portal")
	public void user_searches_for_on_samsung_portal(String productName) {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(productName);
		actions.sendKeys(Keys.ENTER).perform();
	    
	}
	@Then("Refrigerators are dispalyed on Samsung portal")
	public void refrigerators_are_dispalyed_on_samsung_portal()
    {
		WebElement productResult=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'183L Stylish Grandé Design Single Door Refrigerator RR20D2725U')]")));
		Assert.assertTrue(productResult.isDisplayed());
	}

}
