package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IIESTStepDefinition extends BaseStepDefinition
{
	@Given("User is on IIEST portal")
	public void user_is_on_iiest_portal() 
	{
	    driver.get("https://www.iiests.ac.in/en");
	}
	@When("User is on Homepage on IIEST portal")
	public void user_is_on_homepage_on_iiest_portal() 
	{
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.iiests.ac.in/en", "User is not on the homepage");
	}
	@Then("below menu options are displayed")
	public void below_menu_options_are_displayed(io.cucumber.datatable.DataTable dataTable) 
	{
	    List<WebElement> allMenuOptions=driver.findElements(By.xpath("(//a[@href='/en'])[2]/parent::div//ul//li/*"));
	    ArrayList<String> menuOptions=new ArrayList<String>();
	    for(WebElement option: allMenuOptions)
	    {
	    	menuOptions.add(option.getText());
	    }
	    
	    List<Map<String, String>> dataList=dataTable.asMaps(String.class, String.class);
	    Assert.assertEquals(menuOptions.get(3), dataList.get(3).get("menu"));
	}
}
