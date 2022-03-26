package stepDefinition;

import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IPL2022StepDefinition extends BaseStepDefinition {
	
	@Given("^IPL portal is launched$")
	public void ipl_portal_is_launched() throws Exception {
	    driver.get("https://www.iplt20.com/");
	}

	@When("^user navigates to stats section$")
	public void user_navigates_to_stats_section() throws Exception {
		WebElement stats=driver.findElement(By.xpath("(//*[@data-slug='stats'])[2]"));
		WebElement allTimeStats=driver.findElement(By.xpath("(//*[@data-url='/stats/all-time'])[2]"));
	    actions.moveToElement(stats).click(allTimeStats).build().perform();
	}

	@Then("^the all times stats are displayed$")
	public void the_all_times_stats_are_displayed() throws Exception {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(text(),'All Time Batting Leaders')]")));
	    List<WebElement> allTimeGreats=driver.findElements(By.xpath("//*[@class='leaders-2021']"));
	    Iterator<WebElement> itr=allTimeGreats.iterator();
	    int count=0;
	    while(itr.hasNext())
	    {
	    	if(count==6)
	    	{
	    		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(text(),'All Time Bowling Leaders')]")));
	    	}
	    	js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", itr.next());
	    	Thread.sleep(800);
	    	count++;
	    	
	    }
	}



}
