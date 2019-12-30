package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import readLocator.Locator;

public class ImageDisplayed extends BasePage{
	
	By numberOfLikes = By.xpath(Locator.getLocator("imagePage_getNumberOfLikes"));
	By photoComments = By.xpath(Locator.getLocator("imagePage_photoComments"));
	By commentReplies = By.xpath(Locator.getLocator("imagePage_commentReplies"));
	By photoDescription = By.xpath(Locator.getLocator("imagePage_photoDescription"));
	By likeButton = By.xpath(Locator.getLocator("imagePage_photoLikeButton"));
	By profileLink = By.xpath(Locator.getLocator("imagePage_profileLink"));
	By searchedHashtag = By.xpath(Locator.getLocator("searchPage_searchedHashTag"));
	By listOfHashTags = By.xpath(Locator.getLocator("searchPage_listOfHashTags"));
	By commentTextBox = By.cssSelector(Locator.getLocator("imagePage_commentTextBox"));
	By postCommentButton = By.xpath(Locator.getLocator("imagePage_postButton"));
	By listOfReplyToCommentButton = By.xpath(Locator.getLocator("imagePage_replyButton"));
	By unlikePhotoButton = By.xpath(Locator.getLocator("imagePage_unlikePhotoButton"));
	By closeButton = By.xpath(Locator.getLocator("imagePage_closePhotoButton"));
	By photoPostedTime = By.xpath(Locator.getLocator("imagePage_photoPostedTime"));
	
	public ImageDisplayed(WebDriver driver) {
		super(driver);
	}
	
	public void closePhoto(){
		click(closeButton);
	}
	
	public int getNumberOfLikes(){
		String likes = findElement(numberOfLikes).getText();
		int numberOfLikes = Integer.parseInt(likes);
		return numberOfLikes;
	}
	
	public List<WebElement> getAllComments(){
		return findElements(photoComments);
	}
	
	public WebElement getPhotoDescription(){
		return findElement(photoDescription);
	}
	
	public boolean checkIfPhotoIsLiked(){
		//return findElement(unlikePhotoButton).isDisplayed();
		return findElements(unlikePhotoButton).size()>0;
	}
	
	public void likePhoto(){
		click(likeButton);
	}
	
	public WebElement getProfileLink(){
		return findElement(profileLink);
	}
	
	public void goToProfile(){
		click(profileLink);
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
	
	public void addCommentToPhoto(String comment){
		type(commentTextBox, comment);
		click(postCommentButton);
	}
	
	public List<WebElement> listOfReplyToComment(){
		return findElements(listOfReplyToCommentButton);
	}
	
	public String getPhotoPostedTime(){
		return findElement(photoPostedTime).getText();
	}

}
