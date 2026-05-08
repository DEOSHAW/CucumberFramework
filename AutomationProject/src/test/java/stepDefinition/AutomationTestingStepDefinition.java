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
	
	@Given("User navigates to accordion page on Automation Testing portal")
	public void user_navigates_to_accordion_page_on_automation_testing_portal() 
	{
	    driver.findElement(By.xpath("//a[text()='Accordion']")).click();
	    String pageHeader=driver.findElement(By.cssSelector("h2#content")).getText();
	    Assert.assertEquals(pageHeader, "Accordion Test");
	}
	
	@Then("below accordion title is present {string}")
	public void below_accordion_title_is_present(String accordionTitle)
	{
	    boolean accordionPresent=driver.findElement(By.xpath("//div[text()='"+accordionTitle+"']")).isDisplayed();
	    Assert.assertTrue(accordionPresent,accordionTitle+" is not present");
	}
	
	@When("user navigates to Actions page")
	public void user_navigates_to_actions_page() 
	{
	    driver.get("https://www.automationtesting.co.uk/actions.html");
	}
	@When("user performs the drag and drop action")
	public void user_performs_the_drag_and_drop_action() throws InterruptedException 
	{
		WebElement draggable=driver.findElement(By.cssSelector("p#dragtarget"));
		WebElement dropTarget = driver.findElement(By.xpath("(//div[@class='droptarget'])[2]"));
	    actions.dragAndDrop(draggable, dropTarget).perform();
	    Thread.sleep(3000);
	}
	@Then("success message for drag and drop is displayed")
	public void success_message_for_drag_and_drop_is_displayed() 
	{
		String successMsg=driver.findElement(By.cssSelector("p#demo")).getText();
		Assert.assertEquals(successMsg, "The p element was dropped into an accepted rectangle");
	    
	}
}
