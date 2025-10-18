package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LetCodeStepDefinition extends BaseStepDefinition
{
	Select superHeroesDropdown;
	@Given("User is on LetCode portal")
	public void user_is_on_let_code_portal() 
	{
	    driver.get("https://letcode.in/dropdowns");
	}
	@When("User selects below multiple options from dropdown on LetCode")
	public void user_selects_below_multiple_options_from_dropdown_on_let_code(io.cucumber.datatable.DataTable dataTable) 
	{
	    superHeroesDropdown=new Select(driver.findElement(By.cssSelector("select#superheros")));
	    List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
	    if(superHeroesDropdown.isMultiple())
	    {
	    	superHeroesDropdown.selectByValue(dataList.get(0).get("actionHeroes"));
	    	superHeroesDropdown.selectByValue(dataList.get(1).get("actionHeroes"));
	    }
	}
	@Then("the selections are made on LetCode")
	public void the_selections_are_made_on_let_code() 
	{
	    String successMessage=driver.findElement(By.cssSelector("div.notification.is-success>p")).getText();
	    String selectedOption=superHeroesDropdown.getAllSelectedOptions().get(0).getText();
	    for(WebElement option:superHeroesDropdown.getAllSelectedOptions())
	    {
	    	System.out.println(option.getText());
	    }
	    Assert.assertEquals(successMessage, "You have selected "+selectedOption);
	}




}
