package readLocator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Locator {
	
	public static String getLocator(String key) {
		String value = null;
		try{
		    FileReader reader=new FileReader(".\\src\\main\\resources\\locator.properties");  
		    Properties prop=new Properties();  
		    prop.load(reader);
		    value = prop.get(key).toString();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return value;
	}

}
