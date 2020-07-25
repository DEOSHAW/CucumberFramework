package stepDefinition;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QRStepDefinition {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	Result result;
	
	@Given("^QR Portal is launched$")
	public void qr_Portal_is_launched() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   //driver.get("https://testautomationpractice.blogspot.com/");
		   driver.get("file:///C:/Users/Bishal/Downloads/DeoQRCode.png");
	}

	@When("^Scans QR Code$")
	public void scans_QR_Code() throws Throwable {
	    //String source=driver.findElement(By.xpath("//*[text()='QR Code']/following::div/img")).getAttribute("src");
	    String source=driver.findElement(By.xpath("/html/body/img")).getAttribute("src");
	    URL url=new URL(source);
		BufferedImage bufferedimage=ImageIO.read(url);
		LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
		result =new MultiFormatReader().decode(binaryBitmap);
		
	}

	@Then("^Prints QR Code Details$")
	public void prints_QR_Code_Details() throws Throwable {
		System.out.println("QRcode text is: "+result.getText());
		driver.close();
	}


	

}
