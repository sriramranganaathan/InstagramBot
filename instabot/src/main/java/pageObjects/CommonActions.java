package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import readLocator.Locator;

public class CommonActions extends BaseClass{
	
	static Logger log = Logger.getLogger(CommonActions.class);
	
	By homePageIcon = By.xpath(Locator.getLocator("commonAction_homePageIcon"));
	By notificationPanelText = By.xpath(Locator.getLocator("commonAction_turnNotificationOnOrOffPanelText"));
	By turnOffNotification = By.xpath(Locator.getLocator("commonAction_turnOffNotification"));
	By turnOnNotification = By.xpath(Locator.getLocator("commonAction_turnOnNotification"));
	By loginLink = By.xpath(Locator.getLocator("commonAction_loginLink"));
	By userName = By.xpath(Locator.getLocator("commonAction_userName"));
	By passwordd = By.xpath(Locator.getLocator("commonAction_password"));
	By loginButton = By.xpath(Locator.getLocator("commonAction_loginButton"));
	
	public CommonActions(WebDriver driver){
		super(driver);
	}
	
	public void goToHomePage(){
		click(homePageIcon);
	}
	
	public boolean checkIfTurnNotificationPopupAppears(){
		return isDisplayed(notificationPanelText);
	}
	
	public void turnOnNotificationsFromPopup(){
		try{
			if(checkIfTurnNotificationPopupAppears()){
				click(turnOnNotification);
			}
		}
		catch(Exception e){
			log.error("Cannot find notification panel", e);
		}
	}
	
	public void turnOffNotificationsFromPopup(){
		try{
			if(checkIfTurnNotificationPopupAppears()){
				click(turnOffNotification);
			}
		}
		catch(Exception e){
			log.error("Cannot find notification panel", e);
		}
	}
	
	public void loginToUserAccount(String url, String username, String password){
		driver.navigate().to(url);
		type(userName, username);
		type(passwordd, password);
		click(loginButton);
	}

}
