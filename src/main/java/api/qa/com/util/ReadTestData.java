package api.qa.com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTestData {
	
	
	public static JSONObject getJsonData() throws IOException, ParseException {
		
		//pass the path of the .json file
		File file = new File("resources/Testdata/testdata.json");
		
		//converts the json file to String
		String json	= FileUtils.readFileToString(file, "UTF-8");
		
		//parse string to object - serialization
		Object obj = new JSONParser().parse(json);
		
		//convert the object to JSONObject
		JSONObject jsonObject = (JSONObject) obj;
		
		return jsonObject;
		
	}
	
	public static String getTestData(String keyname) throws IOException, ParseException {
		
		String testdata;
		
		return testdata = (String) getJsonData().get(keyname);
	}

}
