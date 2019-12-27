package readConfig;

import java.io.FileReader;
import java.util.Properties;

public class Config {
	
	public static String getValue(String key) {
		String value = null;
		try{
		    FileReader reader=new FileReader(".\\src\\main\\resources\\config\\configFile.properties");  
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
