package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationTestingStepDefinition extends BaseStepDefinition
{
	@Given("User navigates to Automation Testing portal")
	public void user_navigates_to_automation_testing_portal()
	{
	    driver.get("https://www.automationtesting.co.uk/index.html");
	}
	@When("User is on homepage of Automation Testing portal")
	public void user_is_on_homepage_of_automation_testing_portal() 
	{
		String homePageHeader=driver.findElement(By.tagName("h1")).getText();
	    Assert.assertEquals(homePageHeader, "Testing Arena");
	}
	@Then("menu has below links")
	public void menu_has_below_links(io.cucumber.datatable.DataTable dataTable)
	{
	    List<WebElement> allMenuOptions=driver.findElements(By.xpath("//nav[@id='menu']//li/a"));
	    List<List<String>> menuOptions=dataTable.asLists(String.class);
	    Assert.assertEquals(allMenuOptions.get(3).getText(), menuOptions.get(0).get(1));
	}


}
