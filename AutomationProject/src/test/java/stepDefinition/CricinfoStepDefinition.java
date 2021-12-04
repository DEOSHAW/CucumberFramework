package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CricinfoStepDefinition extends BaseStepDefinition {
	StringBuilder topRunGetters=new StringBuilder();
	List<WebElement> Players;
	
	@Given("^ESPN CricInfo site is launched$")
	public void espn_CricInfo_site_is_launched() throws Exception {
	    driver.get("https://stats.espncricinfo.com/Ci/content/records/223646.html");
	}

	@Given("^the user find the top five run getters$")
	public void the_user_find_the_top_five_run_getters() throws Exception {
		for(int i=1;i<=5;i++)
		{
			
			topRunGetters.append(driver.findElement(By.xpath("(//*[@class='engineTable']//tbody//tr//td/a)["+i+"]")).getText());
			topRunGetters.append("  ");
			topRunGetters.append(driver.findElement(By.xpath("(//*[@class='engineTable']//tbody/tr/td/a[contains(@href,'player')]/parent::td/following-sibling::td[5])["+i+"]")).getText());
			topRunGetters.append("\n");
			
		}
	    driver.findElements(By.xpath("//*[@class='engineTable']//tbody//tr//td/a"));
	}

	@Then("^the list of highest run getters is displayed$")
	public void the_list_of_highest_run_getters_is_displayed() throws Exception {
	    js.executeScript("alert(arguments[0])", topRunGetters.toString());
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	}



}
