package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GumTreeStepDefinition extends BaseStepDefinition
{
	@Given("GumTree portal is open")
	public void gum_tree_portal_is_open() {
	    driver.get("https://www.gumtree.com/");
	}
	@When("User searches for below items on GumTree")
	public void user_searches_for_below_items_on_gum_tree(io.cucumber.datatable.DataTable dataTable) throws Exception 
	{
	   List<Map<String,String>> dataList= dataTable.asMaps(String.class,String.class);
	   String searchTerm=dataList.get(1).get("ItemName");
	   driver.findElement(By.xpath("//input[contains(@aria-label,'Type search query')]")).sendKeys(searchTerm);
	   Robot robot=new Robot();
	   robot.keyPress(KeyEvent.VK_ENTER);
	   Thread.sleep(2000);
	   robot.keyRelease(KeyEvent.VK_ENTER);
	   
	}
	@Then("the serach results are displayed on the GumTree portal")
	public void the_serach_results_are_displayed_on_the_gum_tree_portal() 
	{
		String searchResultLabel=driver.findElement(By.xpath("//h1[contains(text(),'Furniture & Homeware for Sale')]")).getText();
		Assert.assertTrue(searchResultLabel.contains("Furniture & Homeware for Sale"));
	    
	}


}
