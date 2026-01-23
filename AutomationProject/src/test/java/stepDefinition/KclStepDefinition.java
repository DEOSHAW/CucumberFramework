package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KclStepDefinition extends BaseStepDefinition
{
	@Given("KCL portal is open")
	public void kcl_portal_is_open() 
	{
	    driver.get("https://kabaddichampionsleague.com/");
	}
	@When("User navigates to standings page on KCL portal")
	public void user_navigates_to_standings_page_on_kcl_portal() 
	{
	    driver.findElement(By.xpath("//a[@href='/standings']")).click();
	}
	@Then("Standings is printed")
	public void standings_is_printed() 
	{
		int rowNum=driver.findElements(By.xpath("//table[@class='leaderboard-table table-striped']//tbody//tr")).size();
		for(int i=1;i<=rowNum;i++)
		{

		System.out.println(driver.findElement(By.xpath("//table[@class='leaderboard-table table-striped']//tbody//tr["+i+"]//td[2]")).getText());
				
		}   
	}
}
