package getRequest;

import org.json.simple.JSONObject;
import org.junit.Test;
import commonUtilities.ReusableFunctions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DemoTest extends ReusableFunctions {
	
	@SuppressWarnings("unchecked")
	@Test
	public void demogetrequest() {
		try {
			// Get Request
			Response res = RestAssured.get("http://demo4032024.mockable.io/apitest");
			
			//Assertion 1
			if(statusCodeCheck(res.getStatusCode())) {
				System.out.println("Assertion 1: PASS");
			}else {
				System.out.println("Assertion 1: FAIL");
			}
			
			//Assertion 2
			JSONObject headerVal = new JSONObject();
			headerVal.put("Content-Type", res.getHeader("Content-Type"));
			headerVal.put("Server", res.getHeader("Server"));
			if(responseHeaderCheck(headerVal)) {
				System.out.println("Assertion 2: PASS");
			}else {
				System.out.println("Assertion 2: FAIL");
			}
			
			//Assertion 3
			JsonPath responseBody = res.jsonPath();
			if(responseValueCheck("Status","200",responseBody.get("status").toString()) &&
					responseValueCheck("Age","25",responseBody.get("employeeData[0].age").toString()) &&
					responseValueCheck("Role","QA Automation Developer",responseBody.get("employeeData[0].role").toString()) &&
					responseValueCheck("DOB","25-02-1994",responseBody.get("employeeData[0].dob").toString()) &&
					responseValueCheck("Message","data retrieved successful",responseBody.get("message").toString())) {
				System.out.println("Assertion 3: PASS");
			}else {
				System.out.println("Assertion 3: FAIL");
			}
			
			//Assertion 4
			if(responseValueCheck("Company", "ABC Infotech", responseBody.get("employeeData[0].company").toString())) {
				System.out.println("Assertion 4: PASS");
			}else {
				System.out.println("Assertion 4: FAIL");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
