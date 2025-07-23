package chetanDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Chetan {
	@Test
	
	public void fillMandatoryFields() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Puja");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Dhotri");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(generateNewEmail());
		driver.findElement(By.xpath("//input[@name=\"telephone\"]")).sendKeys("6756787");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Pass@123");
		driver.findElement(By.xpath("//input[@name=\"confirm\"]")).sendKeys("Pass@123");
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		String textHeading=driver.findElement(By.xpath("//div[@id=\"content\"]//h1")).getText();
		String expectedText="Your Account Has Been Created!";
		assertEquals(textHeading, expectedText);
		
		
	}
	public String generateNewEmail()
	{
		return new Date().toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com";	
	
	}
	

}
