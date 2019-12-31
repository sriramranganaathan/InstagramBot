package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import readLocator.Locator;

public class ProfilePage extends BasePage{

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	By followButton = By.xpath(Locator.getLocator("profilePage_followButton"));
	By profileSuggestionButton = By.xpath(Locator.getLocator("profilePage_getProfileSuggestionsButton"));
	By suggestedProfiles = By.xpath(Locator.getLocator("profilePage_getSuggestedProfileLink"));
	By getNumberOfPosts = By.xpath(Locator.getLocator("profilePage_getNumberOfPosts"));
	By profileImages = By.xpath(Locator.getLocator("profilePage_profileImages"));
	
	public void followUser(){
		click(followButton);
	}
	
	public void getProfileSuggestion(){
		click(profileSuggestionButton);
	}
	
	public List<WebElement> getSuggestedProfileLinks(){
		return findElements(suggestedProfiles);
	}
	
	public int getNumberOfPosts(){
		String posts = findElement(getNumberOfPosts).getText();
		int numberOfPosts = Integer.parseInt(posts);
		return numberOfPosts;
	}
	
	public List<WebElement> findImageSet(){
		return findElements(profileImages);
	}

}
