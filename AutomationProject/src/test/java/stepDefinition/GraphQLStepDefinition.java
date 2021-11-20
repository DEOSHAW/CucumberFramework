package stepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GraphQLStepDefinition extends BaseStepDefinition {
	
	@Given("^GraphQL Portal is launched$")
	public void graphql_Portal_is_launched() throws Exception {
	    driver.get("https://graphql.org/");
	}

	@When("^the user seraches for a \"([^\"]*)\"$")
	public void the_user_seraches_for_a(String searchTerm) throws Exception {
	   driver.findElement(By.id("hero-search-input")).sendKeys(searchTerm);
	   Robot robot=new Robot();
	   if(driver.findElements(By.xpath("//h1[text()='Introduction to GraphQL']")).size()==0)
	   {
	   robot.keyPress(KeyEvent.VK_ENTER);
	   Thread.sleep(500);
	   robot.keyRelease(KeyEvent.VK_ENTER);
	   }
	   robot.keyPress(KeyEvent.VK_ENTER);
	   Thread.sleep(500);
	   robot.keyRelease(KeyEvent.VK_ENTER);
	   
	}

	@Then("^the result is displayed$")
	public void the_result_is_displayed() throws Exception {
		WebElement searchResult=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
	   js.executeScript("alert(arguments[0])", searchResult.getText());
	   Thread.sleep(2500);
	   driver.switchTo().alert().accept();
	}



}
