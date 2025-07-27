package chetanDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003 {
@Test
	public void registerAccount() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("ChetanPuja");
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("DhotriKale");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(emailAutogen());
		driver.findElement(By.name("telephone")).sendKeys("1111111111");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("ChetanPuja");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("ChetanPuja");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedText=driver.findElement(By.xpath("//div[@id=\"content\"]")).getText();
		
		String expectedText1=driver.findElement(By.xpath("//div[@id=\"content\"]//h1")).getText();
		String expectedText2=driver.findElement(By.xpath("(//div[@id=\"content\"]//p)[1]")).getText();
		String expectedText3=driver.findElement(By.xpath("(//div[@id=\"content\"]//p)[2]")).getText();
		String expectedText4=driver.findElement(By.xpath("(//div[@id=\"content\"]//p)[3]")).getText();
		String expectedText5=driver.findElement(By.xpath("(//div[@id=\"content\"]//p)[4]")).getText();
		
		Assert.assertTrue(expectedText.contains(expectedText1));
		Assert.assertTrue(expectedText.contains(expectedText2));
		Assert.assertTrue(expectedText.contains(expectedText3));
		Assert.assertTrue(expectedText.contains(expectedText4));
		Assert.assertTrue(expectedText.contains(expectedText5));
		
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		
		
	}
public String emailAutogen() {
	return new java.util.Date().toString().replaceAll("\\s", "").replaceAll(":", "")+"@gmail.com";
}
}
