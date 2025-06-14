package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GlobomanticsStepDefinition extends BaseStepDefinition
{

@Given("Globomantics portal is open")
public void globomantics_portal_is_open() {
   driver.get("https://www.pluralsight.com/teach/author-tools/globomantics/index");
}
@Then("Robotics menu option is highlighted")
public void robotics_menu_option_is_highlighted() throws InterruptedException {
    WebElement roboticsLink=driver.findElement(RelativeLocator.with(By.xpath("//a[@href='robotics.html']"))
    		.toRightOf(By.xpath("//a[text()='Brands' and @href='#' and @class='nav-link']")));
    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", roboticsLink);
    Thread.sleep(2000);
}

}
