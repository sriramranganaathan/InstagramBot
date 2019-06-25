package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import readLocator.Locator;

public class ImageDisplayed extends BaseClass{
	
	By numberOfLikes = By.xpath(Locator.getLocator("imagePage_getNumberOfLikes"));
	By photoComments = By.xpath(Locator.getLocator("imagePage_photoComments"));
	By commentReplies = By.xpath(Locator.getLocator("imagePage_commentReplies"));
	By photoDescription = By.xpath(Locator.getLocator("imagePage_photoDescription"));
	By likeButton = By.xpath(Locator.getLocator("imagePage_photoLikeButton"));
	By profileLink = By.xpath(Locator.getLocator("imagePage_profileLink"));
	By searchedHashtag = By.xpath(Locator.getLocator(""));
	By listOfHashTags = By.xpath(Locator.getLocator("searchPage_listOfHashTags"));

	public ImageDisplayed(WebDriver driver) {
		super(driver);
	}
	
	public String getNumberOfLikes(){
		return findElement(numberOfLikes).getText();
	}
	
	public List<WebElement> getAllComments(){
		return findElements(photoComments);
	}
	
	public WebElement getPhotoDescription(){
		return findElement(photoDescription);
	}
	
	public void likePhoto(){
		findElement(likeButton).click();
	}
	
	public WebElement getProfileLink(){
		return findElement(profileLink);
	}
	
	public List<WebElement> getListOfHashTags(){
		return findElements(listOfHashTags);
	}
	
	public boolean checkIfHashTagExists(String expectedHashTag, By locator){
		boolean isFound = false;
		for(WebElement element:getListOfHashTags()){
			if(element.getText().contains(expectedHashTag))
				isFound= true;
		}
		return isFound;
	}

}
