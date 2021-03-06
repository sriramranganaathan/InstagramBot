package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;
import readLocator.Locator;

public class HomePage extends BasePage{
	
	By searchBox = By.xpath(Locator.getLocator("homepage_searchBar"));
	By explore = By.xpath(Locator.getLocator("homePage_explore"));
	By activity = By.xpath(Locator.getLocator("homePage_activityFeed"));
	By profile = By.cssSelector(Locator.getLocator("homePage_userProfile"));
	By watchAllStories = By.xpath(Locator.getLocator("homePage_watchAllStories"));
	By seeAllSuggestions = By.xpath(Locator.getLocator("homePage_seeAllSuggestion"));
	By instagramLogoHomePageHeader = By.xpath(Locator.getLocator("instagramLogoHomePageHeader"));
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void returnToHomePage() throws InterruptedException{
		click(instagramLogoHomePageHeader);
		Thread.sleep(2500);
	}
	
	public void search(String searchText){
		type(searchBox, searchText);
		click(By.xpath("//span[text()='"+searchText+"']"));
	}
	
	public void clickExplore(){
		click(explore);
	}
	
	public void clickNotification(){
		click(activity);
	}
	
	public void clickProfile(){
		click(profile);
	}
	
	public void watchAllStories(){
		CommonActions commonactions = new CommonActions(driver);
		commonactions.goToHomePage();
		click(watchAllStories);
	}
	
	public void seeAllSuggestions(){
		CommonActions commonactions = new CommonActions(driver);
		commonactions.goToHomePage();
		click(seeAllSuggestions);
	}

}
