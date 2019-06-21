package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BaseClass {
	
	protected WebDriver driver;
	
	public BaseClass(WebDriver driver){
		this.driver = driver;
	}
	
	public void getDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitUntilElementFound(By locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement findElement(By locator){
		waitUntilElementFound(locator);
		return driver.findElement(locator);
	}
	
	public void click(By locator){
		findElement(locator).click();
	}
	
	public void type(By locator, String text){
		findElement(locator).sendKeys(text);
	}

}
