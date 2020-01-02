package botActions;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;
import flagForPhotos.Photo;
import pageObjects.CommonActions;
import pageObjects.HomePage;
import pageObjects.ImageDisplayed;
import pageObjects.ProfilePage;
import pageObjects.SearchPage;
import readConfig.Config;

public class LikeActions extends BaseTest{
	
	public LikeActions(WebDriver driver){
		super(driver);
	}
	
	private static Logger logger = Logger.getLogger(LikeActions.class);
	
	/**
	 * scenario:1
	 * Search for hash tag->get photo-> get likes and comments
	 * Click image and like
	 * @throws InterruptedException 
	 */
	@Test(priority=1, groups={"likes"})
	public void likePostsThroughHashTags() throws InterruptedException{
		CommonActions commonactions = new CommonActions(driver);
		commonactions.loginToUserAccount(Config.getValue("loginURL"), Config.getValue("userName"), Config.getValue("password"));
		logger.info("logged into application");
		if(commonactions.checkIfTurnNotificationPopupAppears()){
			logger.info("notification popup appears");
			commonactions.turnOffNotificationsFromPopup();
			logger.info("turned off notification popup");
		}
		HomePage homepage = new HomePage(driver);
		homepage.returnToHomePage();
		List<String> hashtagList = readData("HashTag");
		logger.info("List of hashtags: "+hashtagList.toString());
		
		for(String hashtag : hashtagList){
			if(getLikeCount()<Integer.parseInt(readData("LikesCountCriteria").get(0))){
				//Search for hash tag from home page
				homepage.search(hashtag);
				logger.info("Searched hashtag: "+hashtag);
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
			else{
				break;
			}
		}
	}
	
	public void getPhotosAnalyzeClickAndLike(WebElement element, String imageLikes, String imageComments) throws InterruptedException{
		
		ImageDisplayed image = new ImageDisplayed(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		int numberOfLikes = Integer.parseInt(imageLikes);
		int numberOfComments = Integer.parseInt(imageComments);
		if(numberOfLikes>=400 && numberOfComments>10){
			actions.click().build().perform();
			Thread.sleep(1500);
			if(image.checkIfPhotoIsLiked()==false){
				image.likePhoto();
				photoLikedCount++;
				logger.info("Liked count: "+String.valueOf(photoLikedCount));
				Thread.sleep(2000);
			}
			image.closePhoto();
		}
		else if(numberOfLikes>=50){
			actions.click().build().perform();
			Thread.sleep(1500);
			if(Photo.photoTimingWithNumberOfLikesCriteria()&&image.checkIfPhotoIsLiked()==false){
				image.likePhoto();
				photoLikedCount++;
				logger.info("Liked count: "+String.valueOf(photoLikedCount));
				Thread.sleep(2000);
			}
			image.closePhoto();
		}
	}
	
	/**
	 * Get inside user's profile
	 * Select recent photos randomly
	 * like posts
	 * @throws InterruptedException 
	 */
	@Test(priority=2, groups={"likes"})
	public void likeUserPhotosRandomly() throws InterruptedException{
		HomePage homepage = new HomePage(driver);
		ProfilePage profile = new ProfilePage(driver);
		ImageDisplayed image = new ImageDisplayed(driver);
		List<String> users = readData("Users");
		for(String user:users){
			homepage.returnToHomePage();
			homepage.search(user);
			List<WebElement> photos = profile.findImageSet();
			for(int i=0; i<2; i++){
				getRandomElement(photos).click();
				if(image.checkIfPhotoIsLiked()==false){
					image.likePhoto();
					photoLikedCount++;
				}
				image.closePhoto();
				Thread.sleep(1500);
			}
			writeLikeCount(photoLikedCount);
		}
	}
	
	public WebElement getRandomElement(List<WebElement> list){
		Random rand = new Random(); 
        return list.get(rand.nextInt(list.size()));
	}

}
