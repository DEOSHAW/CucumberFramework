package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BoeingStepDefinition extends BaseStepDefinition
{
	
	@Given("Boeing portal is open")
	public void boeing_portal_is_open()
	{
	   driver.get("https://www.boeing.com/");
	}
	@When("User navigates to Our company page")
	public void user_navigates_to_our_company_page()
	{
		WebElement ourCompanyLink=driver.findElement(By.xpath("(//a[text()='Our Company'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", ourCompanyLink);
		ourCompanyLink.click();
	   
	}
	@Then("Company information is displayed")
	public void company_information_is_displayed() throws InterruptedException
	{
		String companyInfo=driver.findElement(By.xpath("//p[contains(text(),'aerospace company')]")).getText();
		js.executeScript("alert(arguments[0])", companyInfo);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	    
	}




}
