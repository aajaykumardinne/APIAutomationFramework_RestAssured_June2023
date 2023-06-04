package api.qa.com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {

	public static final String commonFilePath = System.getProperty("user.dir") + "/config.properties";
	
	public static String propertyReader(String key) {
		
		String value = null;
		
		//InputStream is required while loading into the Properties
		//top-casting scenario -> child class object can be referred by parent class ref variale
		
		try(InputStream input = new FileInputStream(commonFilePath)){
			
			Properties prop = new Properties();
			
			//load the properties file
			prop.load(input);
			
			//getProperty will fetch the value according to the key
			value = prop.getProperty(key);
			
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
	}	
	
	
	
	
}
