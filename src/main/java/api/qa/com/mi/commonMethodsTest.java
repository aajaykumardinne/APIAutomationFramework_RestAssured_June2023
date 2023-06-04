package api.qa.com.mi;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import api.qa.com.util.Helper;
import api.qa.com.util.ReadTestData;

public class commonMethodsTest {
	
	
	public static String getURI() throws IOException, ParseException {
		String uri = Helper.propertyReader("qaBaseUrl") + ReadTestData.getTestData("ExpectedGetURi");
		return uri;
	}

}
