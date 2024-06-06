package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoQAStepDefinition extends BaseStepDefinition
{
	static boolean flag=false;
	@Given("DemoQA portal is launched")
	public void demo_qa_portal_is_launched() {
	    driver.get("https://demoqa.com/droppable");
	}
	@When("user drags and drops the element {string}")
	public void user_drags_and_drops_the_element(String draggableText) throws InterruptedException 
	{
	    driver.findElement(By.id("droppableExample-tab-accept")).click();
	    js.executeScript("window.scrollBy(0,300)");
	    WebElement draggableElement=driver.findElement(By.xpath("//div[text()='"+draggableText+"']"));
	    WebElement dropBox=driver.findElement(By.xpath("(//div[@id='droppable'])[2]"));
	    actions.dragAndDrop(draggableElement, dropBox).perform();
	    Thread.sleep(2000);
	    if(draggableText.equalsIgnoreCase("Acceptable"))
	    {
	    	flag=true;
	    }
	    else
	    {
	    	flag=false;
	    }
	 }
	@Then("Successful message for dropping is displayed")
	public void successful_message_for_dropping_is_displayed() 
	{
		if(flag)
		{
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='droppable'])[2]/p")).getText(), "Dropped!");
		}
		else
		{
			Assert.assertEquals(driver.findElement(By.xpath("(//div[@id='droppable'])[2]/p")).getText(), "Drop here");
		}
	    
	}
	




}
