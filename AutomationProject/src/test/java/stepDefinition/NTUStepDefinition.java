package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NTUStepDefinition extends BaseStepDefinition {
	
	@Given("^NTU portal is launched$")
	public void ntu_portal_is_launched() throws Exception {
	   driver.get("https://www.ntu.edu.sg/");
	}

	@When("^user navigates to Education Section$")
	public void user_navigates_to_Education_Section() throws Exception {
	    driver.findElement(By.xpath("//*[@class='btn-menu-toggle' and @type='button']")).click();
	   WebElement educationLink= driver.findElement(By.xpath("(//a[@href='/education'])[1]"));
	   Thread.sleep(1000);
	   js.executeScript("arguments[0].click();", educationLink);
	   Thread.sleep(2500);
	}

	@Then("^the Education information is displayed$")
	public void the_Education_information_is_displayed() throws Exception {
	    js.executeScript("window.scrollBy(0,300)");
	    WebElement educationInfo=driver.findElement(By.xpath("//*[contains(text(),'Holistic Education')]/parent::div/child::p"));
	    wait.until(ExpectedConditions.visibilityOf(educationInfo));
	    js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", educationInfo);
	    Thread.sleep(2500);
	    System.out.println(educationInfo.getText());
	}



}
