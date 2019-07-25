package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import readLocator.Locator;

public class CommonActions extends BaseClass{
	
	By homePageIcon = By.xpath(Locator.getLocator("commonAction_homePageIcon"));
	
	public CommonActions(WebDriver driver){
		super(driver);
	}
	
	public void goToHomePage(){
		click(homePageIcon);
	}

}