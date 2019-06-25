package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import readLocator.Locator;

public class SearchPage extends BaseClass{
	
	By searchedHashTag = By.xpath(Locator.getLocator("searchPage_searchedHashTag"));
	By numberOfPosts = By.xpath(Locator.getLocator("searchPage_numberOfPosts"));
	By topPosts = By.xpath(Locator.getLocator(""));
	By mostRecentPosts=By.xpath(Locator.getLocator(""));
	By allPosts = By.xpath(Locator.getLocator(""));

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getSearchedHashTag(){
		return findElement(searchedHashTag);
	}
	
	public WebElement getNumberOfPosts(){
		return findElement(numberOfPosts);
	}

}
