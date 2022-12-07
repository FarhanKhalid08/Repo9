package test9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Class9 {
	public static WebDriver driver;
	public static Select select;
	public static WebDriverWait wait;
	
	public static void main (String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rediff.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		String CurrentUrl= driver.getCurrentUrl();
		String ExpectedCurrentUrl= "https://www.rediff.com/";
		String CurrentTitle= driver.getTitle();
		String ExpectedTitle= "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
		Assert.assertEquals(CurrentUrl, ExpectedCurrentUrl);
		Assert.assertEquals(CurrentTitle, ExpectedTitle);
		
		WebElement CreateAccountLink= driver.findElement(By.xpath("//a[contains(text(),'Create Account')]"));
		Assert.assertTrue(CreateAccountLink.isDisplayed());
		CreateAccountLink.click();
		
		WebElement FullName= driver.findElement(By.xpath("//table[@id='tblcrtac']/descendant::input[1]"));
		Assert.assertTrue(FullName.isEnabled());
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(FullName));
		FullName.sendKeys("Farhan khalid");
		
		WebElement EmailId= driver.findElement(By.xpath("//table[@id='tblcrtac']/descendant::input[2]"));
		Assert.assertTrue(EmailId.isDisplayed());
		wait = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(EmailId));
		EmailId.sendKeys("Farhankhalid920");
		
		select = new Select (driver.findElement(By.xpath("//div[@id='div_city']/preceding::select[4]")));
		select.selectByVisibleText("08");
		select = new Select (driver.findElement(By.xpath("//div[@id='div_city']/preceding::select[3]")));
		select.selectByVisibleText("DEC");
		select = new Select(driver.findElement(By.xpath("//div[@id='div_city']/preceding::select[2]")));
		select.selectByVisibleText("1983");
		Assert.assertTrue(true);
		driver.quit();
	}

}
