package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AADHAR_StepDefinition extends BaseStepDefinition {
	 WebElement aboutUIDAIMenu;
	
	@Given("^AADHAR portal is launched$")
	public void aadhar_portal_is_launched() throws Exception {
	    driver.get("https://uidai.gov.in/");
	}

	@When("^user hovers over aboutUDAI link$")
	public void user_hovers_over_aboutUDAI_link() throws Exception {
	    aboutUIDAIMenu=driver.findElement(By.xpath("//span[text()='About UIDAI']"));
	    
	}

	@When("^User click on about link$")
	public void user_click_on_about_link() throws Exception {
		Actions actions=new Actions(driver);
	    actions.moveToElement(aboutUIDAIMenu).click(driver.findElement(By.xpath("//span[text()='About']"))).build().perform();
	}
	
	@Then("^the AADHAR information is displayed$")
	public void the_AADHAR_information_is_displayed() throws Exception {
    String infoText=driver.findElement(By.xpath("//strong[text()='The Unique Identification Authority of India (UIDAI)']/parent::p")).getText();
	  js.executeScript("alert(arguments[0])", infoText);
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	    
	}



}
