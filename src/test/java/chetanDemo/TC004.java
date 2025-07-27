package chetanDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004 {

	@Test
	public void verifyRegistrationWithoutFillingMandatoryFields() {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedErrorString="Warning: You must agree to the Privacy Policy!";
		String expectedErrorFN="First Name must be between 1 and 32 characters!";
		String expectedErrorLN="Last Name must be between 1 and 32 characters!";
		String expectedErrorEmailString="E-Mail Address does not appear to be valid!";
		String expectedErrorTelephoneString="Telephone must be between 3 and 32 characters!";
		String expectedErrorPass="Password must be between 4 and 20 characters!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedErrorString);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), expectedErrorFN);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), expectedErrorLN);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"E-Mail Address does not appear to be valid!\"]")).getText(), expectedErrorEmailString);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), expectedErrorTelephoneString);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(), expectedErrorPass);
		
		driver.quit();
	}

}
