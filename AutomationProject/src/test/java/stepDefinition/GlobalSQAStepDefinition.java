package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlobalSQAStepDefinition extends BaseStepDefinition {
	
	Actions actions;
	WebElement draggableItem;
	@Given("^GlobalSQA portal is open$")
	public void globalsqa_portal_is_open() throws Exception {
	    driver.get("https://www.globalsqa.com/demo-site/draggableboxes/");
	}

	@When("^the element is visible on the webpage$")
	public void the_element_is_visible_on_the_webpage() throws Exception {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='draggable']"))));
	}

	@Then("^User drags it around$")
	public void user_drags_it_around() throws Exception {
	    actions=new Actions(driver);
	    actions.dragAndDropBy(draggableItem, 260, 28);
	    Thread.sleep(5000);
	}


	
	

}
