package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import readLocator.Locator;

public class SearchPage extends BaseClass{
	
	By searchedHashTag = By.xpath(Locator.getLocator("searchPage_searchedHashTag"));
	By numberOfPosts = By.xpath(Locator.getLocator("searchPage_numberOfPosts"));
	By topPosts = By.xpath(Locator.getLocator("searchPage_topPosts"));
	By mostRecentPosts=By.xpath(Locator.getLocator("searchPage_mostRecentPosts"));
	By allPosts = By.xpath(Locator.getLocator(""));
	By searchedPhotos = By.xpath(Locator.getLocator("searchPage_searchedImages"));
	By searchedPhotoNumberOfLikes = By.xpath(Locator.getLocator("searchPage_searchedImageNumberOfLikes"));
	By searchedPhotoNumberOfComments = By.xpath(Locator.getLocator("searchPage_searchedImageNumberOfComments"));

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getSearchedHashTag(){
		return findElement(searchedHashTag);
	}
	
	public WebElement getNumberOfPosts(){
		return findElement(numberOfPosts);
	}
	
	public List<WebElement> getListOfSearchedPhotos(){
		return findElements(searchedPhotos);
	}
	
	public String getNumberOfLikesForSearchedPhoto(){
		return findElement(searchedPhotoNumberOfLikes).getText();
	}
	
	public String getNumberOfCommentsForSearchedPhoto(){
		return findElement(searchedPhotoNumberOfComments).getText();
	}

}
