package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import readLocator.Locator;

public class CommonActions extends BaseClass{
	
	By homePageIcon = By.xpath(Locator.getLocator("commonAction_homePageIcon"));
	By notificationPanelText = By.xpath(Locator.getLocator("commonAction_turnNotificationOnOrOffPanelText"));
	By turnOffNotification = By.xpath(Locator.getLocator("commonAction_turnOffNotification"));
	By turnOnNotification = By.xpath(Locator.getLocator("commonAction_turnOnNotification"));
	
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
			System.out.println("Cannot find notification panel");
			System.out.println(e);
		}
	}
	
	public void turnOffNotificationsFromPopup(){
		try{
			if(checkIfTurnNotificationPopupAppears()){
				click(turnOffNotification);
			}
		}
		catch(Exception e){
			System.out.println("Cannot find notification panel");
			System.out.println(e);
		}
	}

}
