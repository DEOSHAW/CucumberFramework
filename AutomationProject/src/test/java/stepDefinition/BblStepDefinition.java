package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BblStepDefinition extends BaseStepDefinition
{
	@Given("BBL portal is open")
	public void bbl_portal_is_open() 
	{
	    driver.get("https://www.bigbash.com.au/");
	}
	@When("User navigates to standings")
	public void user_navigates_to_standings() 
	{
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//table[contains(@aria-describedby,'competition-standings')]")));
	}
	@Then("standings is displayed on the BBL portal")
	public void standings_is_displayed_on_the_bbl_portal() 
	{
		String teamName="";
	   int rowNum=driver.findElements(By.xpath("//table[contains(@aria-describedby,'competition-standings')]//tbody//tr")).size();
	   int colNum=driver.findElements(By.xpath("//table[contains(@aria-describedby,'competition-standings')]//tbody//tr[1]/td")).size();
	   for(int i=1;i<=rowNum;i++)
	   {
		   teamName=driver.findElement(By.xpath("//table[contains(@aria-describedby,'competition-standings')]//tbody//tr["+i+"]//th//span[2]")).getText();
		   System.out.print(teamName+"  ");
		   for(int j=1;j<=colNum;j++)
		   {
			   
			   System.out.print(driver.findElement(By.xpath("//table[contains(@aria-describedby,'competition-standings')]//tbody//tr["+i+"]/td["+j+"]")).getText()+"  ");
			   
		   }
		   System.out.println();
	   }
	}




}
