package botActions;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CommonActions;
import pageObjects.HomePage;
import pageObjects.ImageDisplayed;
import pageObjects.SearchPage;
import readConfig.Config;

public class FollowActions extends BaseTest{
	
	public FollowActions(WebDriver driver){
		super(driver);
	}

}
