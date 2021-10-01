package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class IPLStepDefinition extends BaseStepDefinition {
	StringBuilder Teams;
	
	@Given("^IPL official website is launched$")
	public void ipl_official_website_is_launched() throws Exception {
		driver.get("https://www.iplt20.com/");
	    
	}

	@Given("^the user finds the next match opponents$")
	public void the_user_finds_the_next_match_opponents() throws Exception {
		int i=1;
	  List<WebElement> Opponents=driver.findElements(By.xpath("//*[@class='teamSmall u-show-tablet']"));
	  Teams=new StringBuilder();
	  for(WebElement team:Opponents)
	  {
	  Teams.append(js.executeScript("return arguments[0].innerHTML;", team));
	     if(i==1)
	      {
	          Teams.append(" VS ");
	       }
	     i++;
	  }
	  
	    
	}

	@Then("^the opponents are displayed$")
	public void the_opponents_are_displayed() throws Exception {
	    js.executeScript("alert(arguments[0])","Next match is between "+Teams.toString());
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	}


}
