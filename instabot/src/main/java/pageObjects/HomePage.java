package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import readLocator.Locator;

public class HomePage extends BaseClass{
	
	By searchBox = By.xpath(Locator.getLocator("homepage_searchBar"));

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void search(String searchText){
		type(searchBox, searchText);
	}

}
