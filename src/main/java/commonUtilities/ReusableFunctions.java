package commonUtilities;

import static org.junit.Assert.assertEquals;
import org.json.simple.JSONObject;

public class ReusableFunctions {
	
	// Utility for Request Status Check 
	public boolean statusCodeCheck(int status) {
		try {
			assertEquals(200, status);
			return true;
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Status is not 200");
			return false;
		}
		
	}
	
	//Utility for Response Header Check
	public boolean responseHeaderCheck(JSONObject headers) {
		try {
			assertEquals("application/json; charset=UTF-8", headers.get("Content-Type"));
			assertEquals("Google Frontend", headers.get("Server"));
			return true;
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("Header Validation Failed");
			return false;
		}
	}
	
	//Utility for Response Value Check
	public boolean responseValueCheck(String property,String expValue, String actValue) {
		try {
			assertEquals(expValue, actValue);
			return true;
		}catch(AssertionError e) {
			System.err.println(e.getMessage());
			System.err.println("Value Mismatch for " + property);
			return false;
		}
	}
}
