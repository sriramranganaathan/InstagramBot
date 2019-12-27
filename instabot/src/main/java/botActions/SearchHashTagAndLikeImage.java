package botActions;

import java.util.Iterator;
import java.util.List;

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

public class SearchHashTagAndLikeImage extends BaseTest{
	
	public SearchHashTagAndLikeImage(WebDriver driver){
		super(driver);
	}
	
	private static Logger logger = Logger.getLogger(SearchHashTagAndLikeImage.class);
	
	/**
	 * scenario:1
	 * Search for hash tag->get photo-> get likes and comments
	 * Click image and like
	 * @throws InterruptedException 
	 */
	@Test
	public void likePostsThroughHashTags() throws InterruptedException{
		CommonActions commonactions = new CommonActions(driver);
		commonactions.loginToUserAccount(Config.getValue("loginURL"), Config.getValue("userName"), Config.getValue("password"));
		logger.info("logged into application");
		if(commonactions.checkIfTurnNotificationPopupAppears()){
			logger.info("notification popup appears");
			commonactions.turnOffNotificationsFromPopup();
			logger.info("turned off notification popup");
		}
		
		List<String> hashtagList = readData("HashTag");
		
		for(String hashtag : hashtagList){
			
			//Search for hash tag from home page
			HomePage homepage = new HomePage(driver);
			homepage.search(hashtag);
			SearchPage searchpage = new SearchPage(driver);
			//Scroll to the bottom of page to get list of photos
			searchpage.scrollPageToBottom();
			Thread.sleep(10000);
			//Iterate through the element list to perform actions
			List<WebElement> listelemnt = searchpage.getListOfSearchedPhotos();
			Iterator<WebElement> itr = listelemnt.iterator();
			while(itr.hasNext()){
				getPhotosAnalyzeClickAndLike(itr.next(), searchpage.getNumberOfLikesForSearchedPhoto(), searchpage.getNumberOfCommentsForSearchedPhoto());
				Thread.sleep(2000);
			}
			writeLikeCount(photoLikedCount);
		}
	}
	
	public void getPhotosAnalyzeClickAndLike(WebElement element, String imageLikes, String imageComments) throws InterruptedException{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		int numberOfLikes = Integer.parseInt(imageLikes);
		int numberOfComments = Integer.parseInt(imageComments);
		if(numberOfLikes>=200 && numberOfComments>10){
			actions.click().build().perform();
			Thread.sleep(1500);
			ImageDisplayed image = new ImageDisplayed(driver);
			if(image.getNumberOfLikes()>=200 & image.checkIfPhotoIsLiked()==false){
				image.likePhoto();
				photoLikedCount++;
				Thread.sleep(2000);
			}
			image.closePhoto();
		}
	}

}
