package pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TennisDotCom 
{
	WebDriver driver;
	public TennisDotCom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css="span.tc-icon--user")
	WebElement userIconLink;
	@FindBy(css="img.auth0-lock-header-logo")
	WebElement logoElement;
	@FindBy(how=How.XPATH,using="//input[@id='1-email']")
	WebElement userNameField;
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement passwordField;
	@FindBy(css="span.auth0-label-submit")
	WebElement logInLink;
	@FindBy(css="span.animated.fadeInUp>span")
	WebElement errorMessage;
	
	
	public void clickOnUserIcon()
	{
		userIconLink.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(logoElement));
		
	}
	
	public String login(String user,String pwd)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		userNameField.sendKeys(user);
		passwordField.sendKeys(pwd);
		logInLink.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
		
	}

}
