package stepDefinition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScienceCityStepDefinition extends BaseStepDefinition {
	String infoText;
	@Given("^Science city portal is launched$")
	public void science_city_portal_is_launched() throws Exception {
	    driver.get("https://sciencecitykolkata.org.in/");
	}

	@When("^user navigates to info section$")
	public void user_navigates_to_info_section() throws Exception {
	    js.executeScript("window.scrollBy(0,500)");
	}

	@When("^user extracts the information$")
	public void user_extracts_the_information() throws Exception {
	  WebElement infoElement = driver.findElement(By.xpath("//*[starts-with(text(),'The Science City')]"));
		infoText=(String) js.executeScript("return arguments[0].innerHTML;", infoElement);
	  System.out.println(infoText);
	}

	@Then("^the informaton is written in a text file$")
	public void the_informaton_is_written_in_a_text_file() throws Exception {
	    File file=new File(System.getProperty("user.dir")+File.separator+"ScienceCity.txt");
	    FileWriter writer=new FileWriter(file,true);
	    BufferedWriter buffWriter=new BufferedWriter(writer);
	    buffWriter.write(infoText);
	    buffWriter.close();
	    writer.close();
	}



}
