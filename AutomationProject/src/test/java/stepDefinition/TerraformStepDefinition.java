package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TerraformStepDefinition extends BaseStepDefinition {
	
	@Given("^Terraform portal is launched$")
	public void terraform_portal_is_launched() throws Exception {
		
		driver.get("https://www.terraform.io/");
	    
	}

	@When("^User looks for below on Terraform portal$")
	public void user_looks_for_below_on_Terraform_portal(DataTable data) throws Exception {
		
		List<Map<String,String>> list=data.asMaps(String.class, String.class);
		
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F);
		
		String searchTerm=list.get(0).get("Term");
		StringSelection str=new StringSelection(searchTerm);
		Clipboard cp=Toolkit.getDefaultToolkit().getSystemClipboard();
		cp.setContents(str, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		
		
		
		
	    
	}

	@Then("^the result is displayed on Terraform portal$")
	public void the_result_is_displayed_on_Terraform_portal() throws Exception {
		
		WebElement openSourceText=driver.findElement(By.xpath("//p[contains(text(),'Download the open source')]"));
		
		String text=(String) js.executeScript("return arguments[0].innerHTML;", openSourceText);
		System.out.println("Open source text is: "+text);
	    
	}



}
