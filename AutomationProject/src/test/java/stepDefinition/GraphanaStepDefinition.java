package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GraphanaStepDefinition extends BaseStepDefinition {
	
	@Given("^Grafana portal is launched$")
	public void grafana_portal_is_launched() throws Exception {
	    driver.get("https://grafana.com/");
	}

	@When("^user clicks on learn button$")
	public void user_clicks_on_learn_button() throws Exception {
	    WebElement learnMenu=driver.findElement(By.xpath("//a[@data-dropdown='learn']"));
	    actions.moveToElement(learnMenu).perform();
	}

	@When("^user clicks on success storied$")
	public void user_clicks_on_success_storied() throws Exception {
	    driver.findElement(By.xpath("(//a[normalize-space(text())='Success stories'])[3]")).click();
	}

	@Then("^Salesforces' success story is displayed$")
	public void salesforces_success_story_is_displayed() throws Exception {
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("success-stories-and-case-studies")));
	    js.executeScript("window.scrollBy(0,100)");
	    String successStoryOfSalesForce=driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Salesforce leverages the Grafana')]")).getText();
	    js.executeScript("alert(arguments[0])", successStoryOfSalesForce);
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();Thread.sleep(1000);
	}



}
