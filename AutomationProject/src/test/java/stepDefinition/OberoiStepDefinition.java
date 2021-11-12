package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class OberoiStepDefinition extends BaseStepDefinition {
	List<WebElement> infoList;
	WebElement info;
	@Given("^TheOberoiHotel portal is launched$")
	public void theoberoihotel_portal_is_launched() throws Exception {
	    driver.get("https://www.oberoihotels.com/");
	}

	@Given("^the user scrolls down to the bottom of the page$")
	public void the_user_scrolls_down_to_the_bottom_of_the_page() throws Exception {
		info=driver.findElement(By.xpath("(//*[@class='award-subtitle'])[1]"));
	    js.executeScript("arguments[0].scrollIntoView();", info);
	    infoList=driver.findElements(By.xpath("//*[@class='award-subtitle']"));
	}

	@Then("^the information is displayed$")
	public void the_information_is_displayed() throws Exception {
	    for(WebElement ele:infoList)
	    {
	    	System.out.println(ele.getText());
	    }
	}



}
