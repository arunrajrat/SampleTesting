package org.automation.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase02 {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Workspaces\\waits\\driver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("shirts");
		
		
	}
}
