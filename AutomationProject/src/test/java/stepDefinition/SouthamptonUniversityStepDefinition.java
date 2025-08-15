package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SouthamptonUniversityStepDefinition extends BaseStepDefinition
{
	@Given("Southampton University portal is open")
	public void southampton_university_portal_is_open()
	{
	    driver.get("https://www.delhi.southampton.ac.uk/");
	}
	@When("User navigates to About us page")
	public void user_navigates_to_about_us_page()
	{
		List<WebElement> rejectAllLink=driver.findElements(By.xpath("//button[@value='reject_additional']"));
		if(rejectAllLink.size()>0)
		{
			rejectAllLink.get(0).click();
			
		}
	    driver.findElement(By.xpath("(//a[normalize-space(text())='About us'])[2]")).click();
	}
	@Then("About us text is displayed")
	public void about_us_text_is_displayed() 
	{
	    String aboutUsText=(String) js.executeScript("return arguments[0].innerHTML;", driver.findElement(By.xpath("//p[starts-with(normalize-space(text()),'We are the first university')]")));
	    System.out.println(aboutUsText);
	    Assert.assertTrue(aboutUsText.contains("We are the first university to receive approval by the University Grants Commission (UGC)"),"About us text does not match");
	}




}
