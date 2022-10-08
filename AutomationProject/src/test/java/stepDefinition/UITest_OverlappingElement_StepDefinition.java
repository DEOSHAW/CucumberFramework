package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UITest_OverlappingElement_StepDefinition extends BaseStepDefinition {
	
	@Given("^UITest Overlapping Element page is open$")
	public void uitest_Overlapping_Element_page_is_open() throws Exception {
	    driver.get("http://uitestingplayground.com/overlapped");
	}

	@When("^user unhides the overlapping text box and enters below values in overlapping text Box$")
	public void user_unhides_the_overlapping_text_box_and_enters_below_values_in_overlapping_text_Box(DataTable table) throws Exception {
		List<Map<String,String>> list=table.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//*[@placeholder='Id']")).sendKeys(list.get(1).get("ID"));
		Thread.sleep(3000);
		WebElement nameTextBox=driver.findElement(By.xpath("//*[@placeholder='Name']"));
		js.executeScript("arguments[0].scrollIntoView();", nameTextBox);
		nameTextBox.sendKeys(list.get(2).get("Name"));
	    
	}

	@Then("^the text should be entered in the overlapped text box$")
	public void the_text_should_be_entered_in_the_overlapped_text_box() throws Exception {
	    Thread.sleep(2000);
	    System.out.println("Text entered");
	}


}
