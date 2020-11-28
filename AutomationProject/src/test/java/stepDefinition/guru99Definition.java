package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class guru99Definition extends BaseStepDefinition {
	Actions actions;
	
	@Given("^Guru(\\d+) portal is launched$")
	public void guru_portal_is_launched(int arg1) throws Throwable {
		
		   driver.get("http://demo.guru99.com/test/drag_drop.html");
		   
	}

	@When("^User drags the item and drops it in the destination location$")
	public void user_drags_the_item_and_drops_it_in_the_destination_location() throws Throwable {
	    actions=new Actions(driver);
	    WebElement draggableItem=driver.findElement(By.xpath("//*[@id='credit2']/a"));
	    //WebElement destination=driver.findElement(By.xpath("//*[@id='mydropzone']"));
	    actions.dragAndDropBy(draggableItem,135,40).build().perform();
	    Thread.sleep(4000);
	}


	@Then("^Portal is closed$")
	public void portal_is_closed() throws Throwable {
		driver.close();
	   
	}


	
	

}
