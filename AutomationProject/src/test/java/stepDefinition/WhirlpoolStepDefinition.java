package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WhirlpoolStepDefinition extends BaseStepDefinition
{
	static String deviceName;
	@Given("Whirlpool portal is open")
	public void whirlpool_portal_is_open()
	{
	    driver.get("https://www.whirlpoolindia.com/");
	}
	@When("User searches for below products on Whirlpool site")
	public void user_searches_for_below_products_on_whirlpool_site(io.cucumber.datatable.DataTable dataTable)
	{
		List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
		deviceName=dataList.get(0).get("LivingRoomProducts");
		try
		{
		driver.findElement(By.tagName("input")).sendKeys(deviceName);
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			driver.findElement(By.tagName("input")).sendKeys(deviceName);
		}
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		
	    
	}
	@Then("the search result is displayed on the Whirlpool portal")
	public void the_search_result_is_displayed_on_the_whirlpool_portal()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement pageHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='"+deviceName.toLowerCase()+"']")));
		Assert.assertEquals(pageHeader.getText(), deviceName.toLowerCase());
	    
	}




}
