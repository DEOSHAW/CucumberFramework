package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoventryUniversityStepDefinition extends BaseStepDefinition
{
	@Given("Coventry university portal is open")
	public void coventry_university_portal_is_open() 
	{
	    driver.get("https://www.coventry.ac.uk/");
	}
	@When("User navigates to Research page")
	public void user_navigates_to_research_page() 
	{
	    driver.findElement(By.xpath("//button[@data-href='/research/']")).click();
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/research/about-us/']"))).click();
	}
	@Then("URL contains below term")
	public void url_contains_below_term(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains(dataList.get(0).get(0)));
	    
	}



	

}
