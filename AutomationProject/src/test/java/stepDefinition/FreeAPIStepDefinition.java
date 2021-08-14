package stepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FreeAPIStepDefinition extends BaseStepDefinition {
	
	@Given("^Free API portal is launched$")
	public void free_API_portal_is_launched() throws Exception {
	   driver.get("https://apipheny.io/free-api/");
	}

	@When("^user looks up for \"([^\"]*)\"$")
	public void user_looks_up_for(String searchKey) throws Exception {
	    driver.findElement(By.xpath("//*[@class='ti-search']")).click();
	    WebElement textBox=driver.findElement(By.xpath("//*[@placeholder='Search here']"));
	    wait.until(ExpectedConditions.visibilityOf(textBox)).sendKeys("Any API");
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(1500);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	}

	@Then("^the search results will be shown$")
	public void the_search_results_will_be_shown() throws Exception {
	    List<WebElement> searchResults=driver.findElements(By.xpath("//*[contains(text(),'Search result for: “Any API”')]//following-sibling::p"));
	    if(searchResults.size()>0)
	    {
	    	Iterator<WebElement> itr=searchResults.iterator();
	    	System.out.println("Search results are: ");
	    	while(itr.hasNext())
	    	{
	    		System.out.println(itr.next().getText());
	    	}
	    }
	}



}
