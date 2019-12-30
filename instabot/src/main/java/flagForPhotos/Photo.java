package flagForPhotos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import base.BasePage;
import pageObjects.ImageDisplayed;

public class Photo extends BasePage{
	
	public Photo(WebDriver driver){
		super(driver);
	}
	
	public static void likePhoto(){
		
	}
	
	/**
	 * Look for description of the photo
	 * Ignore if it is an advertisement related
	 * keywords - buy now, limited time, get this now, for sale, offer valid
	 */
	public static boolean containsAdRealtedCaptions(){
		ImageDisplayed image = new ImageDisplayed(driver);
		String caption = image.getPhotoDescription().getText();
		if(Pattern.matches("\b(?)buy now\b", caption)||Pattern.matches("\b(?)limited time\b", caption)||Pattern.matches("\b(?)for sale\b", caption)||Pattern.matches("\b(?)offer valid\b", caption)||Pattern.matches("\b(?)shop now\b", caption)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Check the time of the post
	 * Compare with likes. If the combination qualifies, like photo
	 * if time less than 2h and likes >50, true
	 */
	public static boolean photoTimingWithNumberOfLikesCriteria(){
		ImageDisplayed image = new ImageDisplayed(driver);
		if((image.getPhotoPostedTime().equalsIgnoreCase("2 HOURS AGO")||image.getPhotoPostedTime().equalsIgnoreCase("1 HOUR AGO"))&&image.getNumberOfLikes()>50){
			return true;
		}
		else{
			return false;
		}
	}

}
