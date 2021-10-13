package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ICCStepDefinition extends BaseStepDefinition {
	
	@Given("^ICC portal is launched$")
	public void icc_portal_is_launched() throws Exception {
	    driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
	}

	@Given("^Partners are visible$")
	public void partners_are_visible() throws Exception {
	    WebElement Sponser1=driver.findElement(By.xpath("(//*[@alt='Oppo'])[2]"));
	    js.executeScript("arguments[0].scrollIntoView();", Sponser1);
	}

	@Then("^all the partners are highlighted sequentially$")
	public void all_the_partners_are_highlighted_sequentially() throws Exception {
		WebElement sponsersGroup=driver.findElement(By.xpath("(//*[@class='footer-partners__list'])[2]"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Yellow')", sponsersGroup);
		Thread.sleep(3000);
	}



}
