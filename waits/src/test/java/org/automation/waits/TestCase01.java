package org.automation.waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase01 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Workspaces\\waits\\driver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/text-box");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("abc,123.");
//		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
//		action.moveToElement(submitButton).click().build().perform();
		// Explicit wait 	
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']"))).click();
//		wait.until(ExpectedConditions.(By.xpath("//button[@id='submit']"))).click();
//		wait.until(ExpectedConditions.(By.xpath("//button[@id='submit']"))).click();
//		wait.until(ExpectedConditions.(By.xpath("//button[@id='submit']"))).click();
		//Fluent Wait 
		Wait<WebDriver> fluWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.ignoring(NoSuchElementException.class)
				.pollingEvery(Duration.ofSeconds(5));
		
		WebElement submitButton = (WebElement) fluWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));
		//fluWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")))
		//driver.close();
	}
	
	

}
