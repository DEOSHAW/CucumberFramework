package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YoutubeStepDefinition extends BaseStepDefinition {
	Actions actions;
	
	@Given("^Youtube Portal is launched$")
	public void youtube_Portal_is_launched() throws Exception {
		driver.get("https://www.youtube.com/");
	}

	@When("^user searches for \"([^\"]*)\"$")
	public void user_searches_for(String videoTitle) throws Exception {
		WebElement searchBox=driver.findElement(By.xpath("//*[@placeholder='Search']"));
		searchBox.sendKeys(videoTitle);
		Thread.sleep(1000);
	    actions=new Actions(driver);
	    actions.sendKeys(searchBox,Keys.ENTER).perform();
	}

	@Then("^the search results are displayed$")
	public void the_search_results_are_displayed() throws Exception {
	    List<WebElement> Courses=driver.findElements(By.xpath("//a[contains(@aria-label,'Selenium')]"));
	    System.out.println("Top 10 courses are: ");
	    for(int i=1;i<=10;i++)
	    {
	    	System.out.println(i+"=>=>"+driver.findElement(By.xpath("(//a[contains(@aria-label,'Selenium')])["+i+"]")).getAttribute("aria-label"));
	    }
	}


	



}
