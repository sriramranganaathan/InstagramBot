package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {
	
	protected static WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitUntilElementFound(By locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(300, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
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
	
	public boolean isDisplayed(By locator){
		return findElement(locator).isDisplayed();
	}
	
	public List<WebElement> findElements(By locator){
		waitUntilElementFound(locator);
		return driver.findElements(locator);
	}
	
	public void scrollUsingJavaScriptExecutor(String howMuch){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+howMuch+")", "");
	}
	
	public void scrollPageToBottom(){
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
}
