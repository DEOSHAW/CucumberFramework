package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AsianGamesStepDefinition extends BaseStepDefinition
{
	@Given("Asian Games portal is open")
	public void asian_games_portal_is_open() 
	{
	   driver.get("https://olympic.ind.in/asian-games-2026/");
	}
	@When("User is captures the image")
	public void user_is_captures_the_image() throws IOException 
	{
	    TakesScreenshot ts=(TakesScreenshot)driver;
	    File srcFile=ts.getScreenshotAs(OutputType.FILE);
	    File destFile=new File(System.getProperty("user.dir")+File.separator+"AsianGamesMedalsTally.png");
	    FileHandler.copy(srcFile, destFile);
	}
	@Then("medal tally is captured")
	public void medal_tally_is_captured() 
	{
		File destFile=new File(System.getProperty("user.dir")+File.separator+"AsianGamesMedalsTally.png");
		Assert.assertTrue(destFile.exists(), "The medals tally got captured");
	}

}
