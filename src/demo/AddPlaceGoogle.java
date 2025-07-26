package demo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceDetails;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddPlaceGoogle {

	public static void main(String[] args) {
		
		AddPlaceDetails a= new AddPlaceDetails();
		a.setAccuracy(50);
		a.setAddress("29, side layout, cohen 09");
		a.setLanguage("english");
		a.setName("Shaveta");
		a.setWebsite("www.google.com");
		a.setPhone_number("(+91) 983 893 3937");
		List<String> types= new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		a.setTypes(types);
		Location loc = new Location();
		loc.setLat(38.383494);
		loc.setLng(33.427362);
		a.setLocation(loc);
		
		RequestSpecification res=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		
		ResponseSpecification resspec=new  ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
	 RequestSpecification rs=given().spec(res).body(a);
		String rsponse=rs.when().post("/maps/api/place/add/json")
	.then().spec(resspec).extract().response().asString();
	 System.out.println(rsponse);
}

}