package stepDefinition;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class USOpenStepDefinition extends BaseStepDefinition {
	
	@When("^USOpen portal is open$")
	public void usopen_portal_is_open() throws Exception {
	  driver.get("https://www.usopen.com/");
	}

	@When("^User clicks on players menu$")
	public void user_clicks_on_players_menu() throws Exception {
	   driver.findElement(By.xpath("//a[@aria-label='Players']")).click();
	}

	@When("^User searches for below player$")
	public void user_searches_for_below_player(DataTable data) throws Exception {
		
		List<Map<String,String>> dataList=data.asMaps(String.class, String.class);
	   driver.findElement(By.xpath("//button[contains(text(),'Search by Player')]")).click();
	   driver.findElement(By.xpath("//input[contains(@placeholder,'Search by Player')]")).sendKeys(dataList.get(1).get("PlayerName"));
	}

	@Then("^the player is displayed$")
	public void the_player_is_displayed() throws Exception {
		File src = null;
		
		WebElement playerImage=driver.findElement(By.xpath("//img[@alt='Player Profile']"));
		wait.until(ExpectedConditions.visibilityOf(playerImage));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		src=playerImage.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+File.separator+"Player.png");
		FileHandler.copy(src, dest);
		
	   
	}


}
