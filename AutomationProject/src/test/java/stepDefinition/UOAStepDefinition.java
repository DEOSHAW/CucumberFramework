package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UOAStepDefinition extends BaseStepDefinition
{
	WebElement menuLink;
	@When("User is on UOA portal")
	public void user_is_on_uoa_portal()
	{
	    driver.get("https://www.allduniv.ac.in/");
	}
	@When("User hovers over below link")
	public void user_hovers_over_below_link(io.cucumber.datatable.DataTable dataTable)
	{
	    String linkText=dataTable.asMaps(String.class, String.class).get(2).get("linkName");
	    String xpathLocator="//a[contains(text(),'%s')]";
	    xpathLocator=String.format(xpathLocator, linkText);
	    menuLink=driver.findElement(By.xpath(xpathLocator));
	}
	@Then("the link is highligted on the UOA portal")
	public void the_link_is_highligted_on_the_uoa_portal() throws InterruptedException 
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", menuLink);
		Thread.sleep(3000);
	}




}
