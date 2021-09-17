package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MonsterDotComStepDefinition extends BaseStepDefinition {
	List<WebElement> Employers;
	StringBuilder employerList;
	
	@Given("^Monster India site is open$")
	public void monster_India_site_is_open() throws Exception {
	    driver.get("https://www.monsterindia.com/");
	}

	@When("^user extracts the employers of choice$")
	public void user_extracts_the_employers_of_choice() throws Exception {
		Employers= driver.findElements(By.xpath("(//*[@class='VueCarousel-inner'])[1]/child::a//img"));
	}

	@Then("^the list is displayed$")
	public void the_list_is_displayed() throws Exception {
	   employerList=new StringBuilder();
	   for(WebElement ele:Employers)
	   {
		   employerList.append(ele.getAttribute("title"));
		   employerList.append("\n");
		   
	   }
	   js.executeScript("alert(arguments[0])", employerList.toString());
	   Thread.sleep(3500);
	   driver.switchTo().alert().accept();
	   Thread.sleep(700);
	}



}
